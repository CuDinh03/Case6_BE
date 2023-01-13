package com.example.casestudy6.controller;

import com.example.casestudy6.model.Img;
import com.example.casestudy6.service.impl.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin("*")
@RequestMapping("/img")
public class ImageController {
    @Autowired
    ImageService imageService;

    @PostMapping
    public void saveImg(@RequestBody ArrayList<Img> img) {
        imageService.save(img);
    }
}