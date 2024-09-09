package net.codejava;


import java.security.SecureRandom;

public class OtpGenerator {

    private static final String OTP_CHARACTERS = "0123456789";
    private static final int OTP_LENGTH = 6;
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generateOTP() {
        StringBuilder otp = new StringBuilder(OTP_LENGTH);
        for (int i = 0; i < OTP_LENGTH; i++) {
            otp.append(OTP_CHARACTERS.charAt(RANDOM.nextInt(OTP_CHARACTERS.length())));
        }
        return otp.toString();
    }
}