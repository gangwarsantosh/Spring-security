package spring.security.SpringSecurity.entity;

import java.util.Collection;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;

	 @JoinColumn(unique=true)
	private String username;
	 
	 private String password;

	 public String getUsername() {
		 return username;
	 }

	 public void setUsername(String username) {
		 this.username = username;
	 }

	 public String getPassword() {
		 return password;
	 }

	 public void setPassword(String password) {
		 this.password = password;
	 }

	 public Users(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	 }

	 public Users() {
		super();
		// TODO Auto-generated constructor stub
	 }

	
}
