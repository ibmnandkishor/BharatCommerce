package net.codejava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import net.codejava.model.contactForm;

@Service
public class contactService {
<<<<<<< HEAD
 
=======

>>>>>>> 8980fc56bcad5e7dcb1e9b725e5445738904dc45
    @Autowired
    private JavaMailSender mailSender;

    public void sendContactEmail(contactForm contactForm) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("bharatcommerce04@gmail.com"); // Replace with your email address
        message.setSubject(contactForm.getSubject());
        message.setText("From: " + contactForm.getName() + "\n\n" + contactForm.getMessage());
        message.setReplyTo(contactForm.getEmail());
        mailSender.send(message);
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 8980fc56bcad5e7dcb1e9b725e5445738904dc45
