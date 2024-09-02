package com.aiml_odyssey.AIML_Odyssey.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactUsController {
	@GetMapping("/Contactus")
	public String showContactUs() {
		return "Contactus";
	}
    @PostMapping("/Contactus")
    public String processContactus() {
    	return "redirect:/Contactus";
    }
}
