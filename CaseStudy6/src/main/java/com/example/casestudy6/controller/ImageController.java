package com.example.casestudy6.controller;

import com.example.casestudy6.model.Img;
import com.example.casestudy6.repository.IImgRepo;
import com.example.casestudy6.service.impl.ImageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

    @Autowired
    IImgRepo imgRepo;

    @PostMapping
    public void saveImg(@RequestBody ArrayList<Img> listimg) {
        imageService.saveAll(listimg);
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

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id) {
        Optional<Img> img = imageService.findById(id);
        Img image = img.get();
        if(!img.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        image.setStatus(2);
        imgRepo.save(image);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping
    public void updateImage(@PathVariable("id") Long id, @RequestBody ArrayList<Img> listimg) {
        imageService.updateImage(id, listimg);
    }
}
