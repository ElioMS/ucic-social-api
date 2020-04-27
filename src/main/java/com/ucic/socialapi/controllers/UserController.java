package com.ucic.socialapi.controllers;

import com.ucic.socialapi.models.entity.User;
import com.ucic.socialapi.services.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{documentNumber}")
    public ResponseEntity<?> show(@PathVariable String documentNumber) {
        User user =  userService.findByDocumentNumber(documentNumber);
        return ResponseEntity.ok(user);
    }

}
