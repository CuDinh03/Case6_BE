package com.example.casestudy6.controller;

import com.example.casestudy6.model.Img;
import com.example.casestudy6.model.Status;
import com.example.casestudy6.service.impl.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/images")
public class ImageController {
    @Autowired
    ImageService imageService;

    @PostMapping
    public void saveImg(@RequestBody ArrayList<Img> img) {
        imageService.save(img);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Img> findById(@PathVariable("id") Long id) {
        ArrayList<Iterable> result = new ArrayList<>();
        Iterable<Img> img = imageService.findAllByStatusId(id);
//        if (img.equals("")) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        result.add(img);
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
