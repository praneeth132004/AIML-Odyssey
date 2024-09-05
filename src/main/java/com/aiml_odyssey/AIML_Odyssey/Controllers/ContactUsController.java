package com.aiml_odyssey.AIML_Odyssey.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aiml_odyssey.AIML_Odyssey.Entities.ContactUsForm;
import com.aiml_odyssey.AIML_Odyssey.Services.EmailService;

@Controller
public class ContactUsController {
	@Autowired
    private EmailService emailService;  // Inject EmailService bean

    @GetMapping("/Contactus")
    public String showContactUs(@ModelAttribute("contactUsForm") ContactUsForm contactUsForm) {
        return "Contactus";
    }

    @PostMapping("/Contactus")
    public String processContactUs(@ModelAttribute("contactUsForm") ContactUsForm contactUsForm, 
                                   RedirectAttributes redirectAttributes) {
        try {
            // Use the EmailService to send the email
            emailService.sendContactUsEmail(contactUsForm);

            // Add a success message for the user
            redirectAttributes.addFlashAttribute("successMessage", "Your message has been sent successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            // Add an error message for the user
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while sending your message. Please try again later.");
        }
        return "redirect:/Contactus";
    }
    
}
