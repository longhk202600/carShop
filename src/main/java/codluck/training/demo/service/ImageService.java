package codluck.training.demo.service;

import codluck.training.demo.model.Image;

import java.util.List;
import java.util.Optional;

public interface ImageService {
    void deleteAll();

    void deleteAll(List<Image> entities);

    void deleteAllById(List<Integer> ids);

    void delete(Image entity);

    void deleteById(Integer id);

    long count();

    List<Image> findAllById(List<Integer> ids);

    List<Image> findAll();

    boolean existsById(Integer id);

    Optional<Image> findById(Integer id);

    List<Image> saveAll(List<Image> entities);

    Image save(Image c);

    List<Image> getListImageByCarId(int id);

    List<Image> getImageByCarId(int idCar);
}
