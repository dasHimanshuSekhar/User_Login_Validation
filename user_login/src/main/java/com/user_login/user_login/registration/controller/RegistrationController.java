package com.user_login.user_login.registration.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user_login.user_login.registration.UserRegistrationForm;
import com.user_login.user_login.registration.repository.RegistrationRepository;

@RestController
public class RegistrationController {
	
	@Autowired
	private RegistrationRepository registrationRepository;
	@Autowired
	private RegistrationManualController registrationManualController;
	
	@PostMapping(path = "/registration")
	public UserRegistrationForm doRegistration(@RequestBody UserRegistrationForm userRegistrationForm) {
		registrationManualController.save(userRegistrationForm);
		return userRegistrationForm;
	}
	
	@PostMapping(path = "/multiple_registration")
	public List<UserRegistrationForm> doMultipleRegistration(@RequestBody List<UserRegistrationForm> userRegistrationFormList) {
		for(int i = 0; i < userRegistrationFormList.size(); i ++) {
			registrationManualController.save(userRegistrationFormList.get(i));
		}
		return userRegistrationFormList;
	}
	
	@PostMapping(path = "/user_login")
	public String checkLoginCredential(@RequestBody UserRegistrationForm userCredential) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		String givenRawPassword = userCredential.getPassword();
		String encodedPassword = registrationRepository.findById(userCredential.getEmailId()).orElse(null).getPassword();
		
		if(encoder.matches(givenRawPassword, encodedPassword)) {
			return "Credential Matches !!";
		}
		else {
			return "Credential Matching Failed !!";
		}
	}
	
	@GetMapping(path = "/all_users")
	public List<UserRegistrationForm> getAllUsersDetails() {
		return registrationRepository.findAll();
	}
	
	@GetMapping(path = "/users/{emailId}")
	public Optional<UserRegistrationForm> findByEmailId(@PathVariable String emailId) {
		return registrationRepository.findById(emailId);
	}
	
}
