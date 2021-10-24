package codluck.training.demo.service.Impl;

import codluck.training.demo.model.Car;
import codluck.training.demo.repository.PageRepository;
import codluck.training.demo.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PageSeviceimpl implements PageService {

    @Autowired
    PageRepository pageRepository;

    @Override
    public Page<Car> findAll(Pageable page) {
        return pageRepository.findAll((Pageable) page);
    }

    @Override
    public Page<Car> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.pageRepository.findAll(pageable);
    }

    @Override
    public Page<Car> findAllByStatus(boolean status, int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.pageRepository.findAllByStatus(status, pageable);
    }
}
