package com.aiml_odyssey.AIML_Odyssey.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aiml_odyssey.AIML_Odyssey.Entities.User;
import com.aiml_odyssey.AIML_Odyssey.Services.LoginService;

import jakarta.servlet.http.HttpSession;

@Controller
public class loginController {
	@Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";  // Return the login.html view
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam("email") String email,
                               @RequestParam("password") String password,
                               Model model,
                               HttpSession session) {
        User authenticatedUser = loginService.authenticateUser(email, password);

        if (authenticatedUser != null) {
            // Set the user in session
            session.setAttribute("loggedInUser", authenticatedUser);

            // Redirect to home page after successful login
            return "redirect:/home";
        } else {
            // Authentication failed, show error message
            model.addAttribute("error", "Invalid email or password");
            return "login";  // Return to login page with error message
        }
    }
    
    
}
