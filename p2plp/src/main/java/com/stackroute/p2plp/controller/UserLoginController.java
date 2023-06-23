package com.stackroute.p2plp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.p2plp.model.User;
import com.stackroute.p2plp.service.UserLoginService;

@RestController
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;

    private ResponseEntity<?> responseEntity;

    @PostMapping("/signup")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        try {
            userLoginService.saveUser(user);
            responseEntity = ResponseEntity.ok().body("User saved successfully");
        } catch (Exception e) {
            responseEntity = ResponseEntity.badRequest().body(e.getMessage());
        }
        return responseEntity;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> validateUser(@RequestBody User user) {
        String email = user.getEmail();
        String password = user.getPassword();
        if (userLoginService.validateUser(email, password)) {
            responseEntity = ResponseEntity.ok().body("User validated");
        } else {
            responseEntity = ResponseEntity.badRequest().body("User not validated");
        }
        return responseEntity;
    }
}
