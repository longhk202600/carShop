package codluck.training.demo.repository;

import codluck.training.demo.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
    @Query(value = "select * from car.image where status = true and car_Id =:id", nativeQuery = true)
    List<Image> getListImageByCarId(@Param(value = "id") int id);

    @Query(value = "select * from image where car_Id = :idCar and status = 1", nativeQuery = true)
    List<Image> getImageByCarId(@Param("idCar") int idCar);

    @Modifying
    @Query(value = "update image set image = :image where id = :idImage and status = 1", nativeQuery = true)
    void updateImage(@Param("image") String image, @Param("idImage") int id);
}
