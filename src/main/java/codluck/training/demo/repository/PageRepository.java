package codluck.training.demo.repository;

import codluck.training.demo.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageRepository extends PagingAndSortingRepository<Car, Integer> {
    @Query(value = "select * from car where car.usage =:status and status_Car =TRUE order by id desc", nativeQuery = true)
    Page<Car> findAllByStatus(@Param(value = "status") boolean status,
                              org.springframework.data.domain.Pageable pageable);
}