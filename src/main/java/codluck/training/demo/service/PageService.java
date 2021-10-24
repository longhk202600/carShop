package codluck.training.demo.service;

import codluck.training.demo.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PageService {
    //    public List<Car> getAllCar(Integer pageNo, Integer pageSize, String sortBy);
    Page<Car> findPaginated(int pageNo, int pageSize);

    Page<Car> findAll(Pageable page);

    Page<Car> findAllByStatus(boolean status, int pageNo, int pageSize);
}
