package com.ucic.socialapi.controllers;

import com.ucic.socialapi.models.entity.Like;
import com.ucic.socialapi.models.entity.User;
import com.ucic.socialapi.models.request.LikeRequest;
import com.ucic.socialapi.models.response.LikeResponse;
import com.ucic.socialapi.models.response.MessageResponse;
import com.ucic.socialapi.services.likes.LikeService;
import com.ucic.socialapi.services.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/likes")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> index(@RequestParam String type, @RequestParam Integer resourceId) {

        HashMap<String, Object> response = new HashMap<String, Object>();

        List<Like> likes = likeService.findAll(type, resourceId);
        List<LikeResponse> likesResponse = new ArrayList<>();

        likes.stream().forEach(i -> {

            User user = userService.findByDocumentNumber(i.getUserId().toString());

            LikeResponse l = new LikeResponse();
            l.setId(i.getId());
            l.setDate(i.getDate().toString());
            l.setName(user.getName());
            l.setSurname(user.getLastName());
            l.setAlias(user.alias().toUpperCase());
            l.setDocumentNumber(user.getDocumentNumber());

            likesResponse.add(l);
        });

        response.put("total", likes.size());
        response.put("data", likesResponse);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> store(@RequestBody LikeRequest body) {

        if (likeService.checkIfLikeExists(body)) {
            likeService.delete(body);
            return ResponseEntity.ok(new MessageResponse("OK"));
        }

        return new ResponseEntity<>(likeService.save(body), HttpStatus.CREATED);
    }

}
