package net.codejava;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import net.codejava.service.OtpService;

@Controller
public class UserLogin {

    @Autowired
    private EmailSenderService senderService;

    @Autowired
    private OtpService otpService;

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserLogin(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/user_login")
    public String showLoginPage() {
        return "user_login";
    }

    @PostMapping("/user_login")
    public String loginUser(@RequestParam String email,
                            @RequestParam String password,
                            HttpSession session,
                            Model model) {
        User user = userRepository.findByEmail(email);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            session.setAttribute("adminLoggedIn", true);
            session.setAttribute("verifiedUser", user); // Store user in session
            return "redirect:/user";
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "user_login";
        }
    }

    @GetMapping("/user_logout")
    public String logoutUser(HttpSession session) {
        session.invalidate();
        return "redirect:/user_login";
    }

    @GetMapping("/user")
    public String user(HttpSession session, Model model) {
        if (session.getAttribute("adminLoggedIn") == null) {
            return "redirect:/user_login";
        }

        User user = (User) session.getAttribute("verifiedUser");
        if (user != null) {
            model.addAttribute("userName", user.getFirstName()); // Pass user's name to the view
        }

        return "user";
    }

    @GetMapping("/forgotPassword")
    public String forgotPassword() {
        return "forgotPassword";
    }

    @PostMapping("/check")
    public String checkEmail(@RequestParam String email, HttpSession session, Model model) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            model.addAttribute("error", "Invalid email");
            return "forgotPassword";
        }

        session.setAttribute("email", email);

        // Generate, send, and store OTP
        sendMail(email);

        return "otpverify";
    }

    private void sendMail(String toEmail) {
        String otp = OtpGenerator.generateOTP(); // Correctly generate OTP
        String subject = "Your OTP for Password Reset";
        String body = "Your OTP is: " + otp;

        senderService.sendEmail(toEmail, subject, body); // Send email

        otpService.saveOtp(toEmail, otp); // Save OTP in the database
    }
    
    @GetMapping("/otpverify")
    public String otpverify() {
        return "otpverify";
    }
    
    @PostMapping("/verify")
    public String verify(@RequestParam String otp, HttpSession session, Model model) {
        String email = (String) session.getAttribute("email");
        if (email == null) {
            model.addAttribute("error", "Session expired. Please try again.");
            return "redirect:/forgotPassword";
        }

        Otp otpRecord = otpService.findByOtpAndEmail(otp, email);
        
        if (otpRecord == null) {
            model.addAttribute("error", "Invalid OTP");
            return "otpverify";
        }

        if (otpRecord.isExpired()) {
            model.addAttribute("error", "OTP has expired");
            return "otpverify";
        }

        // Mark OTP as verified
        otpService.markAsVerified(otpRecord);

        // Process after successful OTP verification
        User user = userRepository.findByEmail(email);
        session.setAttribute("verifiedUser", user);
        
        return "newPassword";  // Redirect to a success page or desired location after verification
    }
    
    @PostMapping("/resetPassword")
    public String resetPassword(@RequestParam String newPassword, 
                                @RequestParam String confirmPassword,
                                HttpSession session, 
                                Model model) {
        User user = (User) session.getAttribute("verifiedUser");

        if (user == null) {
            model.addAttribute("error", "Session expired. Please try again.");
            return "redirect:/forgotPassword";
        }

        if (!newPassword.equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match.");
            return "resetPassword"; // Return to the reset password page
        }
        
        // Update the user's password
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
        
        session.invalidate(); // Invalidate the session after successful password reset

        model.addAttribute("success", "Your password has been successfully reset.");
        return "redirect:/user_login"; // Redirect to the login page
    }
}