package spring.security.SpringSecurity.service;


import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	private String secreteKey="fdkjbjksjdghah668586fyufyufhjvhjvjf87wuigfwuiguguifewihbhkryvyuf";

	public String generateToken(String username) {
		Map<String,Object> claims= new HashMap<>();
	
		return Jwts.builder()
				.claims()
				.add(claims)
				.subject(username)
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis()+60*60*30))
				.and()
				.signWith(getKey())
				.compact();
				
	}
	
	private SecretKey getKey() {
		byte[] keyBytes= Decoders.BASE64.decode(secreteKey);
		return Keys.hmacShaKeyFor(keyBytes);
	}

	public String extractUsername(String token) {
		// TODO Auto-generated method stub
		return extractClaims(token,Claims::getSubject);
	}
	private<T> T extractClaims(String token, Function<Claims,T>claimsResolver) {
		final Claims claims = extractAllClaims(token);
		
		return claimsResolver.apply(claims);
		
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parser()
			.verifyWith(getKey())
				.build()
				.parseSignedClaims(token)
				.getPayload();
				
				}

	
	
	public boolean validateToken(String token, UserDetails userDetails) {

		final String username = extractUsername(token);
		return (username.equals(userDetails.getUsername()) && ! isTokenExpired(token));
		
		
	}

	private boolean isTokenExpired(String token) {
		// TODO Auto-generated method stub
		return extractExpiration(token).before(new Date());
	}

	private Date extractExpiration(String token) {
		// TODO Auto-generated method stub
		return extractClaims(token, Claims::getExpiration);
	}

}
