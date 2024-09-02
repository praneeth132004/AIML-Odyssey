package com.aiml_odyssey.AIML_Odyssey.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AIToolsController {
	
	@GetMapping("/aitools")
	public String showAITools(){
		return "aitools";
	}
	
	@PostMapping("/aitools")
	public String processAITools() {
		return "redirect:/aitools";
	}

}
