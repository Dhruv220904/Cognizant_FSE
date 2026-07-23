package com.cognizant.jwtauth.controller;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@RestController
public class AuthenticationController{

 private static final Logger LOGGER=LoggerFactory.getLogger(AuthenticationController.class);

 // Must be at least 256 bits (32 chars) for HS256
 private static final Key SIGNING_KEY=Keys.hmacShaKeyFor(
     "mysecretkeymysecretkeymysecretkey12".getBytes(StandardCharsets.UTF_8));

 // Mandatory Hands On: Create authentication service that returns JWT
 // curl -s -u user:pwd http://localhost:8090/authenticate
 @GetMapping("/authenticate")
 public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader){
  LOGGER.info("START");
  LOGGER.debug("authHeader: {}", authHeader);

  String user=getUser(authHeader);
  String token=generateJwt(user);

  Map<String, String> response=new HashMap<>();
  response.put("token", token);

  LOGGER.info("END");
  return response;
 }

 // Step 2: Read Authorization header and decode the username
 private String getUser(String authHeader){
  String encodedCredentials=authHeader.substring("Basic ".length());
  byte[] decoded=Base64.getDecoder().decode(encodedCredentials);
  String decodedString=new String(decoded, StandardCharsets.UTF_8);
  String user=decodedString.split(":")[0];
  LOGGER.debug("user: {}", user);
  return user;
 }

 // Step 3: Generate token based on the user
 private String generateJwt(String user){
  LOGGER.debug("Generating token for user: {}", user);
  return Jwts.builder()
      .setSubject(user)
      .setIssuedAt(new Date())
      .setExpiration(new Date(System.currentTimeMillis() + 20 * 60 * 1000)) // 20 minutes
      .signWith(SIGNING_KEY, SignatureAlgorithm.HS256)
      .compact();
 }
}
