package com.aiml_odyssey.AIML_Odyssey.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.aiml_odyssey.AIML_Odyssey.Entities.ContactUsForm;

@Service
public class EmailService {
	@Autowired
    private JavaMailSender mailSender;

    public void sendContactUsEmail(ContactUsForm contactUsForm) {
        // Create a SimpleMailMessage object
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("your-email@example.com");  // Replace with the recipient email
        message.setSubject("New Contact Us Message from: " + contactUsForm.getName());
        message.setText("Name: " + contactUsForm.getName() + "\n" +
                        "Email: " + contactUsForm.getEmail() + "\n" +
                        "Message: " + contactUsForm.getMessage());

        // Send the email
        mailSender.send(message);
    }
}
