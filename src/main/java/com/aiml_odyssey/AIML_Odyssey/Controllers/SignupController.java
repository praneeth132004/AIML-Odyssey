package com.aiml_odyssey.AIML_Odyssey.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.aiml_odyssey.AIML_Odyssey.Entities.User;
import com.aiml_odyssey.AIML_Odyssey.Services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class SignupController {
	@Autowired
    private UserService userService;
	
	@GetMapping("/signup")
    public String showSignupForm() {
        return "signup"; // Refers to signup.html in the templates folder
    }
	@PostMapping("/signup")
    public String processSignup(@ModelAttribute("user") User user, Model model, HttpSession session) {
        try {
            userService.saveUser(user);  // Save user to the database
            session.setAttribute("loggedInUser", user);  // Store user in session
            return "redirect:/home";  // Redirect to home page
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred while signing up. Please try again.");
            return "signup";  // Stay on the signup page if there is an error
        }
    }
}
