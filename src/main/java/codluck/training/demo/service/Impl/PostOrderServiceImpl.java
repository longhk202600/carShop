package codluck.training.demo.service.Impl;

import codluck.training.demo.model.PostOrder;
import codluck.training.demo.repository.PostOrderRepository;
import codluck.training.demo.service.PostOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author QuocDA
 * @version 1.1 9/6/2021
 */

@Service
public class PostOrderServiceImpl implements PostOrderService {

    @Autowired
    private PostOrderRepository orderRepository;

    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));

    @Override
    @Transactional
    public void save(PostOrder order, MultipartFile multipartFile) throws IOException {
        Path staticPath = Paths.get("static");
        Path imagePath = Paths.get("images");
        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
        }
        Path file = CURRENT_FOLDER.resolve(staticPath)
                .resolve(imagePath).resolve(multipartFile.getOriginalFilename());
        try (OutputStream os = Files.newOutputStream(file)) {
            os.write(multipartFile.getBytes());
        }
        order.setImage(imagePath.resolve(multipartFile.getOriginalFilename()).toString());
        System.out.println(order.getImage());
        orderRepository.save(order);
    }

    @Override
    public Iterable<PostOrder> findAllExits() {
        return orderRepository.findAllExít();
    }
}
