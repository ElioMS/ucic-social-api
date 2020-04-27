package com.ucic.socialapi.repositories;

import com.ucic.socialapi.models.entity.Commentary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentaryRepository extends JpaRepository<Commentary, Long> {

    List<Commentary> findByTypeAndResourceIdOrderByDateAsc(String type, Integer resourceId);

}
