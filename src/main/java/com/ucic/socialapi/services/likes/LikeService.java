package com.ucic.socialapi.services.likes;

import com.ucic.socialapi.models.entity.Like;
import com.ucic.socialapi.models.request.LikeRequest;

import java.util.List;
import java.util.Optional;

public interface LikeService {
    List<Like> findAll(String type, Integer resourceId);
    boolean checkIfLikeExists(LikeRequest body);
    Like save(LikeRequest body);
    void delete(LikeRequest body);
}
