package com.example.casestudy6.repository;

import com.example.casestudy6.model.Account;
import com.example.casestudy6.model.Img;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IImgRepo extends JpaRepository<Img, Long> {
    @Query(value = "insert into status_img value (:status_id, :img_id)", nativeQuery = true)
    void saveImageStatus(@Param("status_id") Long status_id, @Param("img_id") Long img_id);

    @Query(nativeQuery = true,value = "SELECT * FROM Account WHERE name= :name")
    Img findByName(@Param("name") Img name);
}
