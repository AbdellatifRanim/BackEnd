package com.example.demo.controller;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.User;
import com.example.demo.service.UserIService;
import DTO.LoginDto;

@RestController
public class AuthenticationController {
    @Autowired
    private UserIService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto){
        Optional<User> userOptional = userService.getUserBymailandpwd(loginDto.getMail(), loginDto.getPwd());
        if(userOptional.isPresent()) {
            User user = userOptional.get();
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Échec de l'authentification");
        }
    }
}

