package com.ipze.self_assessment.security.auth.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ipze.self_assessment.security.config.validators.NullOrNotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Data
@Builder
@Valid
@AllArgsConstructor
public class RegistrationRequest {

	@NullOrNotBlank(message = "Name cannot be empty.")
	private String name;

	@NullOrNotBlank(message = "Username cannot be empty.")
	@Pattern(regexp = "(?=\\S+$).+", message = "Username must contain no whitespace.")
	private String username;

	@NullOrNotBlank(message = "Email cannot be empty.")
	@Email(message = "Email is not valid.",
		regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
	@Size(message = "Wrong email length.", min = 3, max = 320)
	private String email;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date birthDate;

	@NullOrNotBlank
	@Pattern(regexp = "(?=[0-9()-]+$).+", message = "Phone Number must contain no unusual characters.")
	private String phoneNumber;


	@NullOrNotBlank
	private String address;

	@NullOrNotBlank(message = "Name cannot be empty.")
	private String role;

	@NullOrNotBlank(message = "Password cannot be empty")
	@Pattern(regexp = "(?=\\S+$).+", message = "Password must contain no whitespace.")
	@Size(min = 6, message = "Password length must be at least 6 symbols.")
	private String password;

	private Optional<RegistrationStudentDto> student;

	private Optional<RegistrationTeacherDto> teacher;

	@Data
	@AllArgsConstructor
	public static class RegistrationStudentDto {

		@JsonFormat(pattern = "yyyy-MM-dd")
		private Date enrollmentDate;

		@NullOrNotBlank
		private String cycle;

		@NullOrNotBlank
		private String studentId;
	}

	@Data
	@AllArgsConstructor
	public static class RegistrationTeacherDto {

		@NullOrNotBlank
		private String teacherId;

		@JsonFormat(pattern = "yyyy-MM-dd")
		private Date birthDate;

		private UUID subdivisionId;

		@JsonFormat(pattern = "yyyy-MM-dd")
		private Date hireDate;
	}

}
