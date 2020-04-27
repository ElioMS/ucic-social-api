package com.ucic.socialapi.controllers;

import com.ucic.socialapi.models.entity.Commentary;
import com.ucic.socialapi.models.entity.User;
import com.ucic.socialapi.models.request.CommentaryRequest;
import com.ucic.socialapi.models.response.CommentaryResponse;
import com.ucic.socialapi.models.response.LikeResponse;
import com.ucic.socialapi.services.commentaries.CommentaryService;
import com.ucic.socialapi.services.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class CommentaryController {

    @Autowired
    private CommentaryService commentaryService;

    @Autowired
    private UserService userService;

    @GetMapping("/commentaries")
    public ResponseEntity<?> index(@RequestParam String type, @RequestParam Integer resourceId) {
        List<Commentary> commentaries = commentaryService.findAll(type, resourceId);

        List<CommentaryResponse> comments = new ArrayList<>();

        commentaries.stream().forEach(i -> {

            User user = userService.findByDocumentNumber(i.getUserId().toString());

            CommentaryResponse l = new CommentaryResponse();
            l.setId(i.getId());
            l.setDate(i.getDate());
            l.setName(user.getName());
            l.setSurname(user.getLastName());
            l.setAlias(user.alias().toUpperCase());
            l.setContent(i.getContent());

            comments.add(l);
        });


        HashMap<String, Object> response = new HashMap<String, Object>();

        response.put("total", commentaries.size());
        response.put("data", commentaries);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/commentaries")
    public ResponseEntity<?> store(@Valid @RequestBody CommentaryRequest body) throws ParseException {
        Commentary commentary = commentaryService.save(body);
        return ResponseEntity.ok(commentary);
    }

}
