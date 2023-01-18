package com.example.casestudy6.service.impl;

import com.example.casestudy6.model.Img;
import com.example.casestudy6.model.Status;
import com.example.casestudy6.repository.IImgRepo;
import com.example.casestudy6.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ImageService implements IImageService<Img> {
    @Autowired
    IImgRepo imgRepo;

    @Autowired
    StatusService statusService;

    Img img1 = new Img();

    @Override
    public void saveAll(ArrayList<Img> img) {
        Status status = statusService.findLastStatus();
        for (int i = 0; i < img.size(); i++) {
            imgRepo.save(img.get(i));
            img1 = imgRepo.findByName(img.get(i).getName());
            imgRepo.saveImageStatus(status.getId(), img1.getId());
        }
    }

    @Override
    public Iterable<Img> findAllByStatusId(Long id) {
        return imgRepo.findAllByStatusId(id);
    }

    @Override
    public Optional<Img> findById(Long id) {
        return imgRepo.findById(id);
    }

    @Override
    public Img findLastImg() {
        return imgRepo.findLastImg();
    }

    public void save(Img img) {
        imgRepo.save(img);
    }
}
