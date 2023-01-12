package com.example.casestudy6.service.impl;

import com.example.casestudy6.model.Img;
import com.example.casestudy6.model.Status;
import com.example.casestudy6.repository.IImgRepo;
import com.example.casestudy6.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ImageService implements IImageService<Img> {
    @Autowired
    IImgRepo imgRepo;

    @Autowired
    StatusService statusService;

    @Override
    public void save(ArrayList<Img> img) {
        Status status = statusService.findLastStatus();
        for (int i = 0; i < img.size(); i++) {
            imgRepo.save(img.get(i));
            Img img1 = imgRepo.findByName(img.get(i));
            imgRepo.saveImageStatus(status.getId(), img1.getId());
        }
    }
}
