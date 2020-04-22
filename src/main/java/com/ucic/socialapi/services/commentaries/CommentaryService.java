package com.ucic.socialapi.services.commentaries;

import com.ucic.socialapi.models.entity.Commentary;
import com.ucic.socialapi.models.request.CommentaryRequest;

import java.util.List;

public interface CommentaryService {
    List<Commentary> findAll(String type, Integer resourceId);
    Commentary save(CommentaryRequest body);
}
