package spring.security.SpringSecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring.security.SpringSecurity.DTO.UserRequest;
import spring.security.SpringSecurity.repo.UserRequestRepo;

@RestController
public class userController {
	
	@Autowired
	UserRequestRepo userRepository;
	
	@GetMapping("/getUser")
	public List<UserRequest> getuser()
	{
		return userRepository.findAll();
	}
	
	@PostMapping("/user")
public String createUser(@RequestBody UserRequest userRequest ) {
		
		
		 // Check if user already exists
         if(userRepository.findByEmail(userRequest.getEmail()).isPresent()) {
        	 return "User already exists";
         };
     
        
       userRepository.save(userRequest);	
       
       return "User has been created";}
}
