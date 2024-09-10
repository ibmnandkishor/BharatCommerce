
package net.codejava.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codejava.Otp;

public interface OtpRepository extends JpaRepository<Otp, Long> {
    Optional<Otp> findByOtpAndEmail(String otp, String email);

}