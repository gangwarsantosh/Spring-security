package spring.security.SpringSecurity.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.security.SpringSecurity.DTO.UserRequest;

public interface UserRequestRepo extends JpaRepository<UserRequest,Long>{
	
	Optional<UserRequest>findByEmail(String email);

}
