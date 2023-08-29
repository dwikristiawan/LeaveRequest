package com.Portofolio.util;
import io.jsonwebtoken.Claims;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtils {
    private String SECREAT_KEY="secreat";
    public String extractUsername(String token){return extraClaim(token,Claims::getSubject);}
    public Date extractExpiration(String token){return extraClaim(token,Claims::getExpiration);}
    public <T> T extraClaim(String token, Function<Claims,T> claimsResolver){
        final Claims claims=extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(SECREAT_KEY).parseClaimsJws(token).getBody();
    }
    private Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new java.util.Date());
    }
    public String generateToken(UserDetails userDetails){
        Map<String, Object>claims=new HashMap<>();
        return creatToken(claims,userDetails.getUsername());
    }
    private String creatToken(Map<String,Object>claims,String subject){
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new java.util.Date(System.currentTimeMillis()))
                .setExpiration(new java.util.Date(System.currentTimeMillis()+1000*60*60*10))
                .signWith(SignatureAlgorithm.HS256,SECREAT_KEY).compact();
    }
    public Boolean validateToken(String token,UserDetails userDetails){
        final String username =extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }
}

