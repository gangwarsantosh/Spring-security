package spring.security.SpringSecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import spring.security.SpringSecurity.filter.JwtFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {	
	
	@Autowired 
	@Lazy
	UserDetailsService userDetailsService;
	
	@Autowired 
	private JwtFilter jwtFilter;
	
	
	@Bean 
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
	    
//	    httpSecurity
//	        .csrf(customizer -> customizer.disable())
//	        .authorizeHttpRequests(auth -> auth
//	                .requestMatchers("/getUser/**").permitAll()
//	                .requestMatchers("/user", "/students/**","/csrf-token").authenticated()
//	                .anyRequest().permitAll() // Good practice to define behavior for "everything else"
//	        )
//	        // Add this to enable a way to actually log in!
//	        //.formLogin(Customizer.withDefaults())
//	        .httpBasic(Customizer.withDefaults());
//	       // .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

	    
		httpSecurity.csrf(customizer ->customizer.disable())
		.authorizeHttpRequests(auth -> auth
		 .requestMatchers("/register/**","/login/**").permitAll() 
				.anyRequest().authenticated())
		.httpBasic(Customizer.withDefaults())
		.sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	    return httpSecurity.build();
	}
	
	@Bean 
	public AuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
		//provider.setPasswordEncoder( NoOpPasswordEncoder.getInstance());
		provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		
		return provider;
	}

	
	@Bean 
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) {
		
		return config.getAuthenticationManager();
	}

}
