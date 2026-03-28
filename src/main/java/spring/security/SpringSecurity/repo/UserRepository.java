package spring.security.SpringSecurity.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.security.SpringSecurity.DTO.UserRequest;

@Repository
public interface UserRepository extends JpaRepository<UserRequest,Long>{
	
	Optional<UserRequest>   findByEmail(String email);
}
