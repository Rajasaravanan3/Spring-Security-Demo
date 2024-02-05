// package com.security.demo.demo.Service;

// import java.time.Instant;
// import java.time.ZoneId;
// import java.time.ZoneOffset;
// import java.time.ZonedDateTime;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Service;

// import com.auth0.jwt.JWT;
// import com.auth0.jwt.algorithms.Algorithm;
// import com.auth0.jwt.exceptions.JWTCreationException;
// import com.auth0.jwt.exceptions.JWTVerificationException;
// import com.security.demo.demo.Entity.User;



// // import java.time.Instant;
// // import java.time.ZonedDateTime;
// // import java.util.Date;

// // import org.springframework.beans.factory.annotation.Value;
// // import org.springframework.stereotype.Service;

// // import com.auth0.jwt.JWT;
// // import com.auth0.jwt.algorithms.Algorithm;
// // import com.auth0.jwt.exceptions.JWTCreationException;
// // import com.auth0.jwt.exceptions.JWTVerificationException;
// // import com.auth0.jwt.interfaces.Claim;
// // import com.security.demo.demo.Entity.User;

// // import java.security.Key;

// // @Service
// // public class TokenProvider {

// //     @Value("${security.jwt.token.secret-key}")
// //     private String JWT_SECRET;

// //     Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

// //     public String generateAccessToken(User user) {
// //         try {
// //             Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);
// //             return JWT.create()
// //                     .withSubject(user.getUsername())
// //                     .withClaim("username", user.getUsername())
// //                     .withExpiresAt(genAccessExpirationDate())
// //                     .sign(algorithm);
// //         } catch (JWTCreationException exception) {
// //             throw new JWTCreationException("Error while generating token", exception);
// //         }
// //     }

// //     public String validateToken(String token) {
// //         try {
// //             Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);
// //             return JWT.require(algorithm)
// //                     .build()
// //                     .verify(token)
// //                     .getSubject();
// //         } catch (JWTVerificationException exception) {
// //             throw new JWTVerificationException("Error while validating token", exception);
// //         }
// //     }

// //     private Instant genAccessExpirationDate() {
// //         return ZonedDateTime.now().plusHours(2).toInstant();
// //     }

// //     public String getUsernameFromToken(String token) {
// //         Claim claims = getClaims(token);
// //         return claims.getSubject();
// //     }

// //     public boolean checkExpirationTime(String token) {
// //         Claim claims = getClaims(token);
// //         return claims.getExpiration().after(new Date(System.currentTimeMillis()));
// //     }

// //     public Claim getClaims(String token) {
// //         return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
// //     }

// // }

// // @Service
// // public class TokenProvider {

// //     @Value("@#$%^ASDFGHLHGFZXCVBMNBVQWERTYPOIUYTRE")
// //     private String JWT_SECRET;

// //     public String generateAccessToken(User user) {
// //         try {
// //             Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);
// //             return JWT.create()
// //                     .withSubject(user.getUsername())
// //                     .withClaim("username", user.getUsername())
// //                     .withExpiresAt(genAccessExpirationDate())
// //                     .sign(algorithm);
// //         } catch (JWTCreationException exception) {
// //             throw new JWTCreationException("Error while generating token", exception);
// //         }
// //     }

// //     public String validateToken(String token) {
// //         try {
// //             Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);
// //             return JWT.require(algorithm)
// //                     .build()
// //                     .verify(token)
// //                     .getSubject();
// //         } catch (JWTVerificationException exception) {
// //             throw new JWTVerificationException("Error while validating token", exception);
// //         }
// //     }

// //     private Instant genAccessExpirationDate() {
// //         return ZonedDateTime.now().plusHours(2).withZoneSameInstant(ZoneId.systemDefault()).toInstant();
// //     }
// // }