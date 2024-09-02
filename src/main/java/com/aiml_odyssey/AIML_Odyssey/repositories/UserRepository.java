package com.aiml_odyssey.AIML_Odyssey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aiml_odyssey.AIML_Odyssey.Entities.User;

//import org.springframework.data.jpa.repository.JpaRepository;
//import com.aiml_odyssey.AIML_Odyssey.Entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

	User findByEmail(String email);
    // You can add custom query methods here if needed
}
