package com.ucic.socialapi.controllers;

import com.ucic.socialapi.models.entity.Commentary;
import com.ucic.socialapi.models.request.CommentaryRequest;
import com.ucic.socialapi.services.commentaries.CommentaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class CommentaryController {

    @Autowired
    private CommentaryService commentaryService;

    @GetMapping("/commentaries")
    public ResponseEntity<?> index(@RequestParam String type, @RequestParam Integer resourceId) {
        List<Commentary> commentaries = commentaryService.findAll(type, resourceId);
        return ResponseEntity.ok(commentaries);
    }

    @PostMapping("/commentaries")
    public ResponseEntity<?> store(@Valid @RequestBody CommentaryRequest body) throws ParseException {
        Commentary commentary = commentaryService.save(body);
        return ResponseEntity.ok(commentary);
    }

}
