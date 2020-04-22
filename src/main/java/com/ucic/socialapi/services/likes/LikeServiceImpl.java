package com.ucic.socialapi.services.likes;

import com.ucic.socialapi.models.entity.Like;
import com.ucic.socialapi.models.request.LikeRequest;
import com.ucic.socialapi.repositories.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Override
    public List<Like> findAll(String type, Integer resourceId) {
        return likeRepository.findByTypeAndResourceId(type, resourceId);
    }

    @Override
    public Like save(LikeRequest body) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;

        try {
            date = formatter.parse(body.getDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Like newLike = new Like();
        newLike.setDate(date);
        newLike.setUserId(body.getUserId());
        newLike.setResourceId(body.getResourceId());
        newLike.setType(body.getType());

        return likeRepository.save(newLike);
    }
}
