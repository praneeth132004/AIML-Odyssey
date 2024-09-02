package com.aiml_odyssey.AIML_Odyssey.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiml_odyssey.AIML_Odyssey.Entities.User;
import com.aiml_odyssey.AIML_Odyssey.repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        // Additional business logic can be added here (e.g., password encryption)
        return userRepository.save(user);
    }

    /*public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }*/
}
