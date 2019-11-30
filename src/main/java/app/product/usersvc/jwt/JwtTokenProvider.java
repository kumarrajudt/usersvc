package app.product.usersvc.jwt;


import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import app.product.usersvc.interfaces.AuthTokenProvider;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider implements AuthTokenProvider{
	
	@Value("${app.jwtSecret}")
    private String jwtSecret;
	
	@Value("${app.jwtExpirationInMs}")
    private int jwtExpirationInMs;
	
	@Override
	public String generateToken(String subject) {
		return generate(subject);
	}
	
	private String generate(String subject) {		
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

	@Override
	public boolean validateToken(String key) {
		// TODO Auto-generated method stub
		return false;
	}

}
