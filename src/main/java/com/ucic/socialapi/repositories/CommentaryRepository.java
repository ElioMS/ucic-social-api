package com.ucic.socialapi.repositories;

import com.ucic.socialapi.models.entity.Commentary;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentaryRepository extends CrudRepository<Commentary, Long> {

    List<Commentary> findByTypeAndResourceId(String type, Integer resourceId);

}
