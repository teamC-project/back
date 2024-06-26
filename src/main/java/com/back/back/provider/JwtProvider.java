package com.back.back.provider;

import java.util.Date;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.SignatureAlgorithm;
@Component
public class JwtProvider {

    @Value("${jwt.secret-key}")
    private String secretKey;

    public String create(String userId) {

        Date expiredDate = Date.from(Instant.now().plus(1, ChronoUnit.HOURS));

        String jwt = null;

        try {
        Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
        
        jwt = Jwts.builder()
            .signWith(key, SignatureAlgorithm.HS256)
            .setSubject(userId)
            .setIssuedAt(new Date())
            .setExpiration(expiredDate)
            .compact();
        } catch (Exception exception) {
            exception.printStackTrace();
        return null;
        }
        return jwt;
    }

    public String validate (String jwt) {
        
        Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

        String userId = null;

        try {
        userId = Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(jwt)
            .getBody()
            .getSubject();
        } catch (Exception exception) {
            exception.printStackTrace();
        return null;
        }
        return userId;
    }

}