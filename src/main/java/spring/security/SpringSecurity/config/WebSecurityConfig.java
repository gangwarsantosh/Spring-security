package spring.security.SpringSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
	
	@Bean 
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
		
		httpSecurity.csrf(csrf -> csrf.disable())   // disable csrf
            .authorizeHttpRequests(auth -> auth
            		.requestMatchers("/getUser/**").permitAll()
            		.requestMatchers("/user").authenticated()
                  // allow all
            );
		return httpSecurity.build();
	}

	
	@Bean 
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	UserDetailsService userDetailsService() {
		UserDetails user1 = User.withUsername("admin").password(this.passwordEncoder().encode("daksh")).roles("admin").build();
		return new InMemoryUserDetailsManager(user1);
	}
}
