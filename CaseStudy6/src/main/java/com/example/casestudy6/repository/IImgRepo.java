package com.example.casestudy6.repository;

import com.example.casestudy6.model.Img;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface IImgRepo extends JpaRepository<Img, Long> {
    @Modifying
    @Transactional
    @Query(value = "insert into status_img value (:status_id, :img_id)", nativeQuery = true)
    void saveImageStatus(@Param("status_id") Long status_id, Long img_id);

    @Query(nativeQuery = true,value = "SELECT * FROM img WHERE name= :name")
    Img findByName(@Param("name") String name);

    @Query(nativeQuery = true,value = "select img.id, img.name, img.status from (SELECT * from status_img where status_img.status_id = :status_id) as statusimg inner join img on img.id = statusimg.img_id")
    Iterable<Img> findAllByStatusId(@Param("status_id") Long id);
}
