package com.ucic.socialapi.repositories;

import com.ucic.socialapi.models.entity.Like;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends CrudRepository<Like, Like> {

    List<Like> findByTypeAndResourceId(String type, Integer resourceId);
    Like findByTypeAndResourceIdAndUserId(String type, Integer resourceId, Integer userId);
    boolean existsLikeByTypeAndResourceIdAndUserId(String type, Integer resourceId, Integer userId);
}
