package net.codejava;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
<<<<<<< HEAD
=======

>>>>>>> 8980fc56bcad5e7dcb1e9b725e5445738904dc45

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
<<<<<<< HEAD
=======
import org.springframework.validation.annotation.Validated;
>>>>>>> 8980fc56bcad5e7dcb1e9b725e5445738904dc45
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

<<<<<<< HEAD
import jakarta.validation.Valid;
=======
import net.codejava.service.ProductService;
>>>>>>> 8980fc56bcad5e7dcb1e9b725e5445738904dc45

@Controller
public class AppController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
<<<<<<< HEAD
=======
    private ProductService productService;
    @Autowired
>>>>>>> 8980fc56bcad5e7dcb1e9b725e5445738904dc45
    private CaptchaService captchaService;

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }
  

    @GetMapping("/register")
    public String showRegistrationForm(Model model, HttpSession session) {
        User user = new User();
        String realCaptcha = captchaService.generateCaptcha();
        user.setHiddenCaptcha(realCaptcha);
        session.setAttribute("captcha", realCaptcha);
        model.addAttribute("user", user);
        return "signup_form";
    }

    @PostMapping("/process_register")
<<<<<<< HEAD
    public String processRegister(@Valid User user, BindingResult bindingResult, Model model, HttpSession session) {
=======
    public String processRegister(@Validated User user, BindingResult bindingResult, Model model, HttpSession session) {
>>>>>>> 8980fc56bcad5e7dcb1e9b725e5445738904dc45
        if (bindingResult.hasErrors()) {
            return "signup_form";
        }

        String sessionCaptcha = (String) session.getAttribute("captcha");
        if (!user.getCaptcha().equals(sessionCaptcha)) {
            model.addAttribute("errorMessage", "CAPTCHA does not match.");
            return "signup_form";
        }

        User existingUser = userRepo.findByEmail(user.getEmail());
        if (existingUser != null) {
            model.addAttribute("errorMessage", "A user with this email already exists.");
            return "signup_form";
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepo.save(user);

        return "user_login";
    }

	/*
	 * @GetMapping("/users") public String listUsers(Model model) { List<User>
	 * listUsers = userRepo.findAll(); model.addAttribute("listUsers", listUsers);
	 * return "users"; }
	 */


    @GetMapping("/captcha")
    @ResponseBody
    public byte[] getCaptchaImage(HttpSession session) {
        String captchaText = (String) session.getAttribute("captcha");
        BufferedImage image = generateCaptchaImage(captchaText);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "png", baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baos.toByteArray();
    }
<<<<<<< HEAD
    


    @GetMapping("/captcha")
    @ResponseBody
    public byte[] getCaptchaImage(HttpSession session) {
        String captchaText = (String) session.getAttribute("captcha");
        BufferedImage image = generateCaptchaImage(captchaText);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "png", baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baos.toByteArray();
    }
=======
>>>>>>> 8980fc56bcad5e7dcb1e9b725e5445738904dc45

    private BufferedImage generateCaptchaImage(String captchaText) {
        int width = 150;
        int height = 50;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);

        g2d.setColor(Color.GREEN);
        Font font = new Font("Arial", Font.BOLD, 35 | Font.ITALIC);
        g2d.setFont(font);
        g2d.drawString(captchaText, 20, 35);

        g2d.dispose();
        return image;
    }
<<<<<<< HEAD
    @GetMapping("/about")
	public String about() {
		return "about";
	}
	/*
	 * @GetMapping("/contact") public String contact(Model model) { // Logic for
	 * /contact page return "contact"; }
	 */
=======
    
    @GetMapping("/about")
    public String about() {
	    return "about";
    }
    
   
    @GetMapping("/ap")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "ap";
    }
     
>>>>>>> 8980fc56bcad5e7dcb1e9b725e5445738904dc45
}