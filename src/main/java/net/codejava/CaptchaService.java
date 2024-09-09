package net.codejava;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
class CaptchaService {
    public String generateCaptcha() {
        Random random = new Random();
        String characters = "01jua34shdaaosq343ewurd34ks4434nxgcudhfb343auk2sxlaia34plsmhwd225efuo67ipwga083dknf";
        StringBuilder captcha = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            captcha.append(characters.charAt(random.nextInt(characters.length())));
        }
        return captcha.toString();
    }
}