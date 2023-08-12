package com.example.jwt.demojwt.Util;

import java.util.Date;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtUtil 
{
	private static final String SECRET_KEY = "harsh"; 
	public String getUserNameFromToken(String token)
	{
		return getClaimFromToken(token, Claims::getSubject);
	}
	
	private <T>T getClaimFromToken(String token,Function<Claims, T>claimResolver)
	{
		final Claims claims = getAllClaimsFromToken(token);
		return claimResolver.apply(claims);
	}
	
	private Claims getAllClaimsFromToken(String token)
	{
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}
	
	public boolean validateToken(String token , UserDetails userDetails)
	{
		String userName = getUserNameFromToken(token);
		return ( userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
	
	public boolean isTokenExpired(String token)
	{
		final Date expiration = getExpiration(token);
		return expiration.before(new Date());
	}
	
	private Date getExpiration(String token)
	{
		return getClaimFromToken(token, Claims::getExpiration);
	}
}
