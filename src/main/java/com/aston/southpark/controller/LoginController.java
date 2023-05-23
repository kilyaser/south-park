package com.aston.southpark.controller;

import com.aston.southpark.model.AccountCredentials;
import com.aston.southpark.service.JwtService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
public class LoginController {
    private final JwtService jwtService;
    private final DaoAuthenticationProvider authenticationProvider;

    @Operation(summary = "To get token by username and password")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> getToken(@RequestBody AccountCredentials credentials) {
        UsernamePasswordAuthenticationToken creds = new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword());

        Authentication auth = authenticationProvider.authenticate(creds);
        UserDetails user = (UserDetails) auth.getPrincipal();
        String jwts = jwtService.getToken(user);
        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + jwts)
                .header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "Authorization")
                .build();
    }
}
