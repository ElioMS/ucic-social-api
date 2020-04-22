package com.ucic.socialapi.services.likes;

import com.ucic.socialapi.models.entity.Like;
import com.ucic.socialapi.models.request.LikeRequest;

import java.util.List;

public interface LikeService {
    List<Like> findAll(String type, Integer resourceId);
    Like save(LikeRequest body);
}
