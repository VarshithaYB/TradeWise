package com.ust.auth_service.controller;

import com.ust.auth_service.config.JwtTokenProvider;
import com.ust.auth_service.dto.*;
import com.ust.auth_service.model.Account;
import com.ust.auth_service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private JwtTokenProvider jwtService;


    @Autowired
    AuthenticationManager authenticationManager;


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        try {
            String response = accountService.register(registerDto);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
   }
    
//    @PostMapping("/register")
//    public ResponseEntity<Map<String, String>> register(@RequestBody RegisterDto registerDto) {
//        // Registration logic here
//        Map<String, String> response = new HashMap<>();
//        response.put("message", "User Registered Successfully");
//        return ResponseEntity.ok(response);
   

   // @PostMapping("/login")
    // public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
    //    return ResponseEntity.ok(accountService.login(loginDto));
  //  }
   @PostMapping("/login")
   public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto loginDto) {
       Authentication authentication = authenticationManager.authenticate(
               new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
       );

       SecurityContextHolder.getContext().setAuthentication(authentication);

       // Fetch user details for token generation
       Optional<Account> existingUser = accountService.findByEmail(loginDto.getEmail());
       if (existingUser.isPresent()) {
           Account foundUser = existingUser.get();
           String jwt = jwtService.createToken(
                   foundUser.getEmail(),
                   //foundUser.getId(),
                   foundUser.getRoles()
           );

           // Create a new LoginResponse with token, id, and role
           LoginResponseDto response = new LoginResponseDto(jwt,foundUser.getRoles());
           return ResponseEntity.ok(response);
       } else {
           return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
       }
   }
   
//   @PostMapping("/login")
//   public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto loginDto) {
//       log.info("Login attempt for email: " + loginDto.getEmail());
//       try {
//           Authentication authentication = authenticationManager.authenticate(
//               new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
//           );
//           log.info("Authentication successful for email: " + loginDto.getEmail());
//           // Token generation and response
//       } catch (BadCredentialsException e) {
//           log.error("Invalid credentials for email: " + loginDto.getEmail());
//           return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
//       }
//   }
   
//   
//   @PostMapping("/login")
//   public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
//       // Retrieve user by username
//       Optional<User> userOptional = userRepository.findByUsername(loginDto.getUsername());
//
//       if (!userOptional.isPresent()) {
//           return ResponseEntity.status(403).body("Invalid username or password.");
//       }
//
//       User user = userOptional.get();
//
//       // Check if the password matches the encoded password
//       if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
//           return ResponseEntity.status(403).body("Invalid username or password.");
//       }
//
//       // If authentication is successful, generate JWT token (you can use a JWT library here)
//       String token = "dummy-jwt-token";  // Replace with actual JWT token generation
//
//       return ResponseEntity.ok(new LoginResponse(token, user.getRole()));
//   }

    @GetMapping("/validate/token")
    public ResponseEntity<Boolean> validateToken(@RequestParam String token) {
        return ResponseEntity.ok(accountService.verify(token));
    }

    @GetMapping("/extract/roles")
    public ResponseEntity<Map<String, Object>> extractRolesFromToken(@RequestParam String token) {
        try {
            if (!accountService.verify(token)) {
                throw new RuntimeException("Invalid or Expired Token");
           }
            String roles = accountService.getRolesFromToken(token);
            Map<String, Object> response = new HashMap<>();
            response.put("roles", roles);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Map.of("error", e.getMessage()));
        }
    }

    @PutMapping("/update/password")
    public ResponseEntity<String> updatePassword(@RequestBody UpdatePasswordDto updatePasswordDto) {
        try {
            accountService.updatePassword(updatePasswordDto);
            return ResponseEntity.ok("Password updated successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/update/email")
    public ResponseEntity<String> updateEmail(@RequestBody UpdateEmailDto updateEmailDto) {
        try {
            accountService.updateEmail(updateEmailDto);
            return ResponseEntity.ok("Email updated successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
