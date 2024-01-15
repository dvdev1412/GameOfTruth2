package com.example.gameoftruth2.services;

import com.example.gameoftruth2.entity.Role;
import com.example.gameoftruth2.entity.User;
import com.example.gameoftruth2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public User createNewAccount(User user, Role role) {

        user.setRoleList(Collections.singletonList(role));
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.saveAndFlush(user);

        return user;

    }

    public User findByUsername(String username) {
       return userRepository.findByUsername(username)
                .orElseThrow(()-> new RuntimeException("Username not found"));


    }
}
