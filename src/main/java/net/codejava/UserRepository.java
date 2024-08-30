package net.codejava;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = :email")
	User findByEmail(String email);

	@Query("SELECT u FROM Otp u WHERE u.otp = :otp")
	Otp findByOtp(String otp);

	

   

   
}