package com.challenge.eshop.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.Date;

@Service
public class JwtService {

    private static final String SECRETKEY = "2f652ab1f2504db56292527c13bbf3e05b235a3340190dbfb13897609f031a0f6195a8474d15968f245e471b8aa591ec7edd62666c96ab50af1b38c1c1eb1ec628c6d177f76ab4b670e22559f494eee27fafcc4b1efb359f27a21dbdb27d1a6179a5db605e453fbc6a1e5b4b25b132b62053497d9362c3e35d5c713c2645cde1\n";

    public String getEmail(String token){
        return getClaim(token, Claims::getSubject);
    }

    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(
            Map<String, Object> claims,
            UserDetails userDetails
    ){
        return Jwts.builder()
                .claims(claims)
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000*60*24))
                .signWith(getSecretKey(), Jwts.SIG.HS256)
                .compact();
    }


    public boolean isTokenValid(String token, UserDetails userDetails){
        final String email = getEmail(token);
        return email.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return getExpiration(token).before(new Date());
    }

    private Date getExpiration(String token) {
        return getClaim(token, Claims::getExpiration);
    }


    public <T> T getClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaims(String token){
        return Jwts.parser()
             .verifyWith(getSecretKey())
             .build()
             .parseSignedClaims(token)
             .getPayload();
    }

    private SecretKey getSecretKey(){
        byte[] keyBites = Decoders.BASE64.decode(SECRETKEY);
        return Keys.hmacShaKeyFor(keyBites);
    }


}
