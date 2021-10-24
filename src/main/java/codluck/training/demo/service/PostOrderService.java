package codluck.training.demo.service;

import codluck.training.demo.model.PostOrder;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PostOrderService {
    void save(PostOrder order, MultipartFile multipartFile) throws IOException;

    Iterable<PostOrder> findAllExits();
}
