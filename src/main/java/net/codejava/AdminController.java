package net.codejava;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String admin() {
        return "admin_login";
    }

    @PostMapping("/admin_login")
    public String adminLogin(@RequestParam("username") String username, 
                             @RequestParam("password") String password, 
                             Model model) {
        // Replace this with your actual admin credentials
        String adminUsername = "admin";
        String adminPassword = "password";

        if (adminUsername.equals(username) && adminPassword.equals(password)) {
            return "admin_dashboard";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "admin_login";
        }
    }
}