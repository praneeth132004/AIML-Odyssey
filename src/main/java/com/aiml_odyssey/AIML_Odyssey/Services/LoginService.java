package com.aiml_odyssey.AIML_Odyssey.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiml_odyssey.AIML_Odyssey.Entities.User;
import com.aiml_odyssey.AIML_Odyssey.repositories.UserRepository;

@Service
public class LoginService {
	@Autowired
    private UserRepository userRepository;

    public User authenticateUser(String email, String password) {
        // Find the user by email
        User user = userRepository.findByEmail(email);

        // Check if user exists and the password matches
        if (user != null && user.getpassword().equals(password)) {
            return user;  // Authentication successful
        }
        return null;  // Authentication failed
    }
}
