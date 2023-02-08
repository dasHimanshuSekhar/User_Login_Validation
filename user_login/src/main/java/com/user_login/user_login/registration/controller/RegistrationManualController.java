package com.user_login.user_login.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.user_login.user_login.registration.UserRegistrationForm;
import com.user_login.user_login.registration.repository.RegistrationRepository;
@Repository
public class RegistrationManualController {
	@Autowired
	private RegistrationRepository registrationRepository;
	
	public void save(UserRegistrationForm userRegistrationForm) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		userRegistrationForm.setPassword(bCryptPasswordEncoder.encode(userRegistrationForm.getPassword()));
		registrationRepository.save(userRegistrationForm);
	}

}
