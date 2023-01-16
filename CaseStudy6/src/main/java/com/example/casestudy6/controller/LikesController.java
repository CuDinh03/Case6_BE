package com.example.casestudy6.controller;

import com.example.casestudy6.model.Likes;
import com.example.casestudy6.service.ILikesService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

@RestController
@CrossOrigin("*")
@RequestMapping("/likes")
public class LikesController {
    @Autowired
    ILikesService iLikesService;

    @PostMapping("/{id}")
    public ResponseEntity<Likes> saveLikes(@RequestBody Likes Likess, @PathVariable("id") Long id) {
        Likess.setStatus(1);
        iLikesService.save(Likess, id);
        return new ResponseEntity(iLikesService.findLastLikes(), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Likes> findById(@PathVariable("id") Long id){
        ArrayList<Iterable> result = new ArrayList<>();
        Iterable<Likes> Likess = iLikesService.findAllByStatusId(id);
        result.add(Likess);
        return new ResponseEntity(result, HttpStatus.OK);
    }
    
}
