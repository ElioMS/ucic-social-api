package com.ucic.socialapi.controllers;

import com.ucic.socialapi.models.entity.User;
import com.ucic.socialapi.services.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{documentNumber}")
    public ResponseEntity<?> show(@PathVariable String documentNumber) {

        if (!userService.existsUserByDocumentNumber(documentNumber)) {
            User user = userService.createAnonymousUser(documentNumber);

            HashMap<String, Object> response = new HashMap<String, Object>();

            response.put("id", user.getId());
            response.put("documentNumber", user.getDocumentNumber());
            response.put("name", "");
            response.put("surname", "");
            response.put("alias", "");

            return ResponseEntity.ok(response);
        }

        User user =  userService.findByDocumentNumber(documentNumber);

        HashMap<String, Object> response = new HashMap<String, Object>();

        response.put("id", user.getId());
        response.put("documentNumber", user.getDocumentNumber());
        response.put("name", user.getName());
        response.put("surname", user.getLastName());
        response.put("alias", ""+user.getName().charAt(0)+user.getLastName().charAt(0));

        return ResponseEntity.ok(response);
    }

}
