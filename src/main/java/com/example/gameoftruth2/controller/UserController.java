package com.example.gameoftruth2.controller;

import org.apache.logging.log4j.message.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.MessageFormat;
import java.util.stream.Collectors;

@Controller
@RequestMapping("api/v1/user")
public class UserController {

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
    public ResponseEntity<String> getUser(@AuthenticationPrincipal UserDetails userDetails) {

        return ResponseEntity.ok(MessageFormat.format("Method called by user: {0}, Role is: {1}",
                userDetails.getUsername(), userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                        .collect(Collectors.joining(","))));
    }
}
