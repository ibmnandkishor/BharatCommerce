
package net.codejava.service;



import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codejava.Otp;
import net.codejava.repository.OtpRepository;

@Service
public class OtpService {

    @Autowired
    private OtpRepository otpRepository;

    public void saveOtp(String email, String otp) {
        Otp otpRecord = new Otp();
        otpRecord.setEmail(email);
        otpRecord.setOtp(otp);
        otpRecord.setGeneratedTime(LocalDateTime.now());
        otpRecord.setUsed(false);

        otpRepository.save(otpRecord);
    }

    public Otp findByOtpAndEmail(String otp, String email) {
        return otpRepository.findByOtpAndEmail(otp, email).orElse(null);
    }

    public void markAsVerified(Otp otpRecord) {
        otpRecord.setUsed(true);
        otpRepository.save(otpRecord);
    }}