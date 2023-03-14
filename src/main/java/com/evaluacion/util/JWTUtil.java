package com.evaluacion.util;

import com.evaluacion.config.properties.SecurityProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class JWTUtil {
    @Autowired
    SecurityProperties securityProperties;
    public String generateToken(Map<String, Object> claims, String subject){
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + (1000 * 60 * securityProperties.getTokenValidityInMinutes())))
                .signWith(SignatureAlgorithm.HS256,securityProperties.getJwtSignatureKey())
                .compact();
    }

    public boolean validateToken(String token,UserDetails userDetails){
        return userDetails.getUsername().equals(extractUsername(token))
                && !isTokenExpired(token);
    }

    public boolean isTokenExpired(String token){
        return getClaims(token).getExpiration().before(new Date());
    }

    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    private Claims getClaims(String token){
        return Jwts.parser().setSigningKey(securityProperties.getJwtSignatureKey()).parseClaimsJws(token).getBody();
    }
}
