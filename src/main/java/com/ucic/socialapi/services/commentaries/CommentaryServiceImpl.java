package com.ucic.socialapi.services.commentaries;

import com.ucic.socialapi.models.entity.Commentary;
import com.ucic.socialapi.models.request.CommentaryRequest;
import com.ucic.socialapi.repositories.CommentaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CommentaryServiceImpl implements CommentaryService {

    @Autowired
    private CommentaryRepository commentaryRepository;

    @Override
    public List<Commentary> findAll(String type, Integer resourceId) {
        return commentaryRepository.findByTypeAndResourceIdOrderByDateAsc(type, resourceId);
    }

    @Override
    public Commentary save(CommentaryRequest body) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;

        try {
            date = formatter.parse(body.getDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Commentary newCommentary = new Commentary();
        newCommentary.setContent(body.getContent());
        newCommentary.setType(body.getType());
        newCommentary.setResourceId(body.getResourceId());
        newCommentary.setUserId(body.getUserId());
        newCommentary.setDate(date);

        return commentaryRepository.save(newCommentary);
    }
}
