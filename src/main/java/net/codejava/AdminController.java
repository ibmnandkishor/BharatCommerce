package net.codejava;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String admin() {
        return "admin_login";
    }

    @PostMapping("/admin_login")
    public String adminLogin(@RequestParam("username") String username, 
                             @RequestParam("password") String password, 
                             HttpSession session,
                             Model model) {
        // Replace this with your actual admin credentials
        String adminUsername = "admin";
        String adminPassword = "password";

        if (adminUsername.equals(username) && adminPassword.equals(password)) {
            // Set session attribute for admin
            session.setAttribute("adminLoggedIn", true);
            return "redirect:/products/list";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "admin_login";
        }
    }

    @GetMapping("/admin_logout")
    public String adminLogout(HttpSession session) {
        // Invalidate the session
        session.invalidate();
        return "redirect:/admin";
    }
    
    
  
 
}
