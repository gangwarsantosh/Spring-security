package spring.security.SpringSecurity.student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import spring.security.SpringSecurity.entity.Users;
import spring.security.SpringSecurity.service.JwtService;
import spring.security.SpringSecurity.service.UserService;

@RestController
public class StudentController {
	
	@Autowired
	private UserService userService;
	
	
	private List<Student> students = new ArrayList<>(List.of(new Student(1,"santosh",500), new Student(2,"daksh",450),new Student(3,"harshit",450)));
	
	
	
	@GetMapping("/students")
	public List<Student> getStudents(){
	
		return students;
		
	}
	@PostMapping("/register")
	public Users createUser(@RequestBody Users user) {
		
		return userService.register(user);
		
	}
	@PostMapping("/login")
	public String login(@RequestBody Users user) {
		return userService.verify(user);
		
	}
	
	@GetMapping("/csrf-token")
	public CsrfToken getCsrfToken(HttpServletRequest request) {
		
		return (CsrfToken) request.getAttribute("_csrf");
		
	}

}
