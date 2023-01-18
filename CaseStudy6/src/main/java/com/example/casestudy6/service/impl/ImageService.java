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
    public void saveAll(ArrayList<Img> listimg) {
        Status status = statusService.findLastStatus();
        for (int i = 0; i < listimg.size(); i++) {
            imgRepo.save(listimg.get(i));
            img1 = imgRepo.findByName(listimg.get(i).getName());
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

    public void updateImage(Long id, ArrayList<Img> listimg) {
        for (int i = 0; i < listimg.size(); i++) {
            if (listimg.get(i).getId() == 0) {
                imgRepo.save(listimg.get(i));
                Img img = imgRepo.findLastImg();
                imgRepo.saveImageStatus(id, img.getId());
            } else {imgRepo.saveImageStatus(id, listimg.get(i).getId());}
        }
    }

    @Override
    public Img findLastImg() {
        return imgRepo.findLastImg();
    }

    public void save(Img img) {
        imgRepo.save(img);
    }
}
