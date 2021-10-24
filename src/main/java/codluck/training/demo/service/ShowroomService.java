package codluck.training.demo.service;

import codluck.training.demo.model.Showroom;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ShowroomService {
    public Showroom getShowroomByUserID(int id);

    Showroom getShowroomByUserId(int userId);

    Showroom getShowroomById(int id);

    void save(Showroom showroom, MultipartFile multipartFile) throws IOException;

    Iterable<Showroom> findAll();

    void deleteById(int id);

}
