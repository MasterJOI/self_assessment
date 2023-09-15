package com.ipze.self_assessment.controller;

import com.ipze.self_assessment.model.entity.User;
import com.ipze.self_assessment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/find")
	public User getUserByEmail(@RequestParam("email") String email) {
		return userService.loadUserByEmail(email);
	}

}
