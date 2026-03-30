package spring.security.SpringSecurity.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.security.SpringSecurity.entity.Users;



@Repository
public interface UserRepository extends JpaRepository<Users,Long>{
	
	Optional<Users> findByUsername(String email);
}
