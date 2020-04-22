package com.ucic.socialapi.repositories;

import com.ucic.socialapi.models.entity.Like;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LikeRepository extends CrudRepository<Like, Like> {

    List<Like> findByTypeAndResourceId(String type, Integer resourceId);
}
