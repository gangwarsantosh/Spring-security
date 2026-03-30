package spring.security.SpringSecurity.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import spring.security.SpringSecurity.DTO.UserRequest;
import spring.security.SpringSecurity.entity.UserPrinciple;
import spring.security.SpringSecurity.entity.Users;
import spring.security.SpringSecurity.repo.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	      
		Users user = userRepo.findByUsername(username)
	            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
		
		
		return new UserPrinciple(user);
	}

}
