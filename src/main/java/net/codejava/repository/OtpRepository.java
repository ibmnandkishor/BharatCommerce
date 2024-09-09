package net.codejava.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import net.codejava.Otp;

import java.util.Optional;

public interface OtpRepository extends JpaRepository<Otp, Long> {
    Optional<Otp> findByOtpAndEmail(String otp, String email);
}