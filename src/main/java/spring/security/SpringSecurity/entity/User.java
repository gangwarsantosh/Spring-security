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
public class User implements UserDetails{
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;

	 @JoinColumn(unique=true)
	private String username;
	 
	 private String password;

	 @Override
	 public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	 }

	 @Override
	 public @Nullable String getPassword() {
		// TODO Auto-generated method stub
		return null;
	 }

	 @Override
	 public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	 }
}
