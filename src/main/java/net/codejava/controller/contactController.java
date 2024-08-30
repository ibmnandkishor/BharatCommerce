package net.codejava.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.codejava.model.contactForm;
import net.codejava.service.contactService;

@Controller
@RequestMapping("/contact")
public class contactController {

    @Autowired
    private contactService contactService;

    @GetMapping
    public String showContactForm(Model model) {
        model.addAttribute("contactForm", new contactForm());
        return "contact";
    }

    @PostMapping
    public String submitContactForm(@ModelAttribute contactForm contactForm, Model model) {
        contactService.sendContactEmail(contactForm);
        model.addAttribute("contactForm", new contactForm()); // Clear the form
        model.addAttribute("message", "Thank you for your message! We will get back to you soon.");
        return "contact"; // Return the same view with message
    }

}