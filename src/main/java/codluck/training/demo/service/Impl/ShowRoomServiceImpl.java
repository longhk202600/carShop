package codluck.training.demo.service.Impl;

import codluck.training.demo.model.Showroom;
import codluck.training.demo.repository.ShowroomRepository;
import codluck.training.demo.service.ShowroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ShowRoomServiceImpl implements ShowroomService {
    @Autowired
    ShowroomRepository showroomRepository;

    @Override
    public Showroom getShowroomByUserID(int id) {
        return showroomRepository.getShowroomByUserID(id);
    }


    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));

    @Override
    public Showroom getShowroomByUserId(int userId) {
        return showroomRepository.getShowroomByUserId(userId);
    }

    @Override
    public Showroom getShowroomById(int id) {
        return showroomRepository.getShowroomById(id);
    }

    @Override
    @Transactional
    public void save(Showroom showroom, MultipartFile multipartFile) throws IOException {
        if (!multipartFile.isEmpty()) {
            Path staticPath = Paths.get("static");
            Path imagePath = Paths.get("image");
            if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
                Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
            }
            Path file = CURRENT_FOLDER.resolve(staticPath)
                    .resolve(imagePath).resolve(multipartFile.getOriginalFilename());
            try (OutputStream os = Files.newOutputStream(file)) {
                os.write(multipartFile.getBytes());
            }
            showroom.setLogo(imagePath.resolve(multipartFile.getOriginalFilename()).toString());
        } else {
            showroom.setLogo(showroom.getLogo());
        }
        showroomRepository.save(showroom);
    }

    @Override
    public Iterable<Showroom> findAll() {
        return showroomRepository.findAllAA();
    }

    @Override
    public void deleteById(int id) {
        showroomRepository.deleteById(id);
    }
}
