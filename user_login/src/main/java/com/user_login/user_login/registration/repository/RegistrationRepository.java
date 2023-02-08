package com.user_login.user_login.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user_login.user_login.registration.UserRegistrationForm;

@Repository
public interface RegistrationRepository extends JpaRepository<UserRegistrationForm, String> {}
