package com.ipze.self_assessment.domains.user;

import com.ipze.self_assessment.domains.selfAssessment.SelfAssessmentInfoMapper;
import com.ipze.self_assessment.domains.subdivision.SubdivisionRepository;
import com.ipze.self_assessment.domains.teacherInformation.dto.TeacherInformationDto;
import com.ipze.self_assessment.domains.user.repo.StudentRepository;
import com.ipze.self_assessment.domains.user.repo.TeacherRepository;
import com.ipze.self_assessment.domains.user.repo.UserRepository;
import com.ipze.self_assessment.model.entity.Student;
import com.ipze.self_assessment.model.entity.Teacher;
import com.ipze.self_assessment.model.entity.User;
import com.ipze.self_assessment.model.enums.StudentType;
import com.ipze.self_assessment.security.auth.dto.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final StudentRepository studentRepository;
	private final TeacherRepository teacherRepository;
	private final SubdivisionRepository subdivisionRepository;

	public void registerNewUserAccount(RegistrationRequest registrationRequest) {
		String role = registrationRequest.getRole();
		final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		User user = new User();
		user.setName(registrationRequest.getName());
		user.setUsername(registrationRequest.getUsername());
		user.setEmail(registrationRequest.getEmail());
		user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
		user.setIsStaff("teacher".equals(role));
		user.setIsActive(true);
		userRepository.save(user);

		if ("student".equals(role)) {
			Optional<RegistrationRequest.RegistrationStudentDto> studentDto = registrationRequest.getStudent();

			if (studentDto.isPresent()) {
				var s = studentDto.get();
				Student student = new Student();

				student.setUser(user);
				student.setBirthdate(registrationRequest.getBirthDate());
				student.setPhoneNumber(registrationRequest.getPhoneNumber());
				student.setAddress(registrationRequest.getAddress());
				student.setStudentId(s.getStudentId());
				student.setStudentType(StudentType.valueOf(s.getStudentType()));
				student.setEnrollmentDate(s.getEnrollmentDate());
				studentRepository.save(student);
			}
		} else if ("teacher".equals(role)) {
			Optional<RegistrationRequest.RegistrationTeacherDto> teacherDto = registrationRequest.getTeacher();

			if (teacherDto.isPresent()) {
				var t = teacherDto.get();
				var department = subdivisionRepository.findById(t.getSubdivision()).orElseThrow();
				Teacher teacher = new Teacher();

				teacher.setUser(user);
				teacher.setBirthdate(registrationRequest.getBirthDate());
				teacher.setPhoneNumber(registrationRequest.getPhoneNumber());
				teacher.setAddress(registrationRequest.getAddress());
				teacher.setTeacherId(t.getTeacherId());
				teacher.setSubdivision(department);
				teacher.setHireDate(t.getHireDate());

				teacherRepository.save(teacher);
			}
		}
	}

	public TeacherInformationDto searchTeacherByFullName(String fullName) {
		var user = this.userRepository.findByName(fullName)
			.orElseThrow(() -> new UsernameNotFoundException("Викладача з таким ім'ям не знайдено."));
		var teacherInformationDto = SelfAssessmentInfoMapper.MAPPER.teacherToDto(user.getTeacher());
		teacherInformationDto.setName(user.getName());
		teacherInformationDto.setSubdivision(user.getTeacher().getSubdivision().getResponsibleDepartment());
		return teacherInformationDto;
	}

}
