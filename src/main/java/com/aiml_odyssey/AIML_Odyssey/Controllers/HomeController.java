package com.aiml_odyssey.AIML_Odyssey.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
   @GetMapping("/home")
   public String home() {
       return "index"; // Returns the view name "index", which corresponds to index.html in the templates folder
   }
}
