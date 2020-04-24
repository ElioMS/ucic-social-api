package com.ucic.socialapi.controllers;

import com.ucic.socialapi.models.entity.Like;
import com.ucic.socialapi.models.request.LikeRequest;
import com.ucic.socialapi.services.likes.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/likes")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @GetMapping
    public ResponseEntity<List<Like>> index(@RequestParam String type, @RequestParam Integer resourceId) {
        return ResponseEntity.ok(likeService.findAll(type, resourceId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Like store(@RequestBody LikeRequest body) {
        return likeService.save(body);
    }

}
