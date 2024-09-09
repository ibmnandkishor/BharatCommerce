package net.codejava;

import java.util.List;
<<<<<<< HEAD
=======
import java.util.Optional;
>>>>>>> 8980fc56bcad5e7dcb1e9b725e5445738904dc45

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = :email")
<<<<<<< HEAD
	/* User findByEmail(@Param("email") String email); */
    User findByEmail(String email);
=======
	User findByEmail(String email);
>>>>>>> 8980fc56bcad5e7dcb1e9b725e5445738904dc45

	@Query("SELECT u FROM Otp u WHERE u.otp = :otp")
	Otp findByOtp(String otp);

	

   

   
}