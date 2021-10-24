package codluck.training.demo.service.Impl;

import codluck.training.demo.model.Image;
import codluck.training.demo.repository.ImageRepository;
import codluck.training.demo.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageRepository imageRepository;

    @Override
    public void deleteAll() {
    }

    @Override
    public List<Image> getImageByCarId(int idCar) {
        return imageRepository.getImageByCarId(idCar);
    }

    @Override
    public void deleteAll(List<Image> entities) {
    }

    @Override
    public void deleteAllById(List<Integer> ids) {
    }

    @Override
    public void delete(Image entity) {
    }

    @Override
    public void deleteById(Integer id) {
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public List<Image> findAllById(List<Integer> ids) {
        return null;
    }

    @Override
    public List<Image> findAll() {
        return null;
    }

    @Override
    public boolean existsById(Integer id) {
        return false;
    }

    @Override
    public Optional<Image> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Image> saveAll(List<Image> entities) {
        return null;
    }

    @Override
    public Image save(Image c) {
        return imageRepository.save(c);
    }

    @Override
    public List<Image> getListImageByCarId(int id) {
        return imageRepository.getListImageByCarId(id);
    }
}
