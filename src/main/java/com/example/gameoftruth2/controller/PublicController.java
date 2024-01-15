package com.example.gameoftruth2.controller;

import com.example.gameoftruth2.entity.Role;
import com.example.gameoftruth2.entity.RoleType;
import com.example.gameoftruth2.entity.User;
import com.example.gameoftruth2.model.UserDto;
import com.example.gameoftruth2.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/public")
@RequiredArgsConstructor
public class PublicController {


    private final UserService userService;

    @GetMapping
    public ResponseEntity<String> getPublic(){
        return ResponseEntity.ok("Called public method");
    }

    @PostMapping("/account")
    public ResponseEntity<UserDto> createUserAccount(@RequestBody UserDto userDto, @RequestParam RoleType roleType) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createAccount(userDto, roleType));

    }

    public UserDto createAccount (UserDto userDto, RoleType roleType){

        var user = new User();

        user.setPassword(userDto.getPassword());
        user.setUsername(userDto.getUsername());

        var createdUser = userService.createNewAccount(user, Role.from(roleType));

        return UserDto.builder()
                .username(createdUser.getUsername())
                .password(createdUser.getPassword())
                .build();

    }

}




