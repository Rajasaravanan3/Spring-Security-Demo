// package com.security.demo.demo;

// // import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

// // import org.springframework.security.core.context.SecurityContextHolder;

// // import org.springframework.security.core.userdetails.UserDetailsService;
// // import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
// // import org.springframework.stereotype.Component;
// // import org.springframework.web.filter.OncePerRequestFilter;

// // import com.security.demo.demo.Service.TokenProvider;

// // import jakarta.servlet.ServletException;
// // import jakarta.servlet.http.HttpServletRequest;
// // import jakarta.servlet.http.HttpServletResponse;
// // import jakarta.servlet.FilterChain;

// // import java.io.IOException;

// // @Component
// // public class JwtTokenFilter extends OncePerRequestFilter {

// //     @Autowired
// //     private TokenProvider tokenProvider;

// //     @Autowired
// //     private UserDetailsService service;

// //     @Override
// //     protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
// //             throws IOException, ServletException {
// //         final String authHeader = req.getHeader("Authorization");
// //         String username = null;
// //         String token = null;

// //         if (authHeader != null && authHeader.contains("Bearer")) {
// //             token = authHeader.substring(7);
// //             System.out.println(token);
// //             try {
// //                 username = tokenProvider.getUsernameFromToken(token);

// //             } catch (Exception e) {
// //                 System.out.println(e.getMessage());
// //             }
// //         }
// //         if (username != null && token != null
// //                 && SecurityContextHolder.getContext().getAuthentication() == null) {
// //             if (tokenProvider.validateToken(token) instanceof String) {
// //                 UsernamePasswordAuthenticationToken upassToken = tokenProvider.getAuthentication    (token, SecurityContextHolder.getContext().getAuthentication(), 
// //                     service.loadUserByUsername(username));

// //                 upassToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
// //                 SecurityContextHolder.getContext().setAuthentication(upassToken);
// //             }
// //         }
// //         chain.doFilter(req, res);
// //     }

// // }

// import java.io.IOException;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.stereotype.Component;
// import org.springframework.web.filter.OncePerRequestFilter;

// import com.security.demo.demo.Repository.UserRepository;
// import com.security.demo.demo.Service.TokenProvider;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// @Component
// public class SecurityFilter extends OncePerRequestFilter {

//     @Autowired
//     TokenProvider tokenService;

//     @Autowired
//     UserRepository userRepository;

//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//         throws ServletException, IOException {
//       var token = this.recoverToken(request);
//       if (token != null) {
//         var login = tokenService.validateToken(token);
//         var user = userRepository.findByLogin(login);
//         var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
//         SecurityContextHolder.getContext().setAuthentication(authentication);
//       }
//       filterChain.doFilter(request, response);
//     }

//     private String recoverToken(HttpServletRequest request) {
//       var authHeader = request.getHeader("Authorization");
//       if (authHeader == null)
//         return null;
//       return authHeader.replace("Bearer ", "");
//     }
// }