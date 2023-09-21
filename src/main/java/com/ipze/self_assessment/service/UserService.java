package com.ipze.self_assessment.service;

import com.ipze.self_assessment.model.dto.auth.RegistrationRequest;
import com.ipze.self_assessment.model.entity.Student;
import com.ipze.self_assessment.model.entity.Teacher;
import com.ipze.self_assessment.model.entity.User;
import com.ipze.self_assessment.repo.StudentRepository;
import com.ipze.self_assessment.repo.SubdivisionRepository;
import com.ipze.self_assessment.repo.TeacherRepository;
import com.ipze.self_assessment.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final SubdivisionRepository subdivisionRepository;

    /*public User loadUserByEmail(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new EmailNotFoundException("User with email : " + email + " not found."));
    }*/

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
                student.setStudentType(s.getStudentType());
                student.setEnrollmentDate(s.getEnrollmentDate());
                studentRepository.save(student);
            }
        } else if ("teacher".equals(role)) {
            Optional<RegistrationRequest.RegistrationTeacherDto> teacherDto = registrationRequest.getTeacher();

            if (teacherDto.isPresent()) {
                var t = teacherDto.get();
                var departments = new HashSet<>(subdivisionRepository.findAllById(t.getSubdivisions()));
                Teacher teacher = new Teacher();

                teacher.setUser(user);
                teacher.setBirthdate(registrationRequest.getBirthDate());
                teacher.setPhoneNumber(registrationRequest.getPhoneNumber());
                teacher.setAddress(registrationRequest.getAddress());
                teacher.setTeacherId(t.getTeacherId());
                teacher.setSubdivisions(departments);
                teacher.setHireDate(t.getHireDate());

                teacherRepository.save(teacher);
            }
        }
    }

}
