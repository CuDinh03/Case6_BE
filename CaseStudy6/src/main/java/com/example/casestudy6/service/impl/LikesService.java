package com.example.casestudy6.service.impl;

import com.example.casestudy6.model.Comment;
import com.example.casestudy6.model.Likes;
import com.example.casestudy6.repository.ILIKERepo;
import com.example.casestudy6.service.ILikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.Like;
import org.springframework.stereotype.Service;

@Service
public class LikesService implements ILikesService {

    @Autowired
    ILIKERepo ilikeRepo;

    @Autowired
    StatusService statusService;
    @Override
    public void save(Likes likes, Long id) {
        ilikeRepo.save(likes);
        Likes likes1 = findLastLikes();
        ilikeRepo.saveLikesStatus(id,likes1.getId());

    }

    @Override
    public Iterable<Likes> findAllByStatusId(Long id) {
       return ilikeRepo.findAllByStatusId(id);
    }

    @Override
    public Likes findLastLikes() {
        return ilikeRepo.findLastLikes();
    }
}
