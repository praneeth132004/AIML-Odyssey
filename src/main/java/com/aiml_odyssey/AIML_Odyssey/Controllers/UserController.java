package com.aiml_odyssey.AIML_Odyssey.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.aiml_odyssey.AIML_Odyssey.Entities.User;
import com.aiml_odyssey.AIML_Odyssey.Services.UserService;

@Controller
public class UserController {
	private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /*@GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";  // Return to signup.html
    }*/

    @PostMapping("/user/signup")
    public String signup(@ModelAttribute("user") User user, Model model) {
        try {
            userService.saveUser(user);
            return "redirect:/home";
        } catch (Exception e) {
            model.addAttribute("error", "An error occurred while signing up. Please try again.");
            return "signup"; // Return to the signup page if there is an error
        }
    }

}


