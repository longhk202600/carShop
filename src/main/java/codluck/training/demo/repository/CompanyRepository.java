package codluck.training.demo.repository;

import codluck.training.demo.model.Car;
import codluck.training.demo.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    @Query(value = "select * from car.company where status = true order by " +
            "id desc limit 4;", nativeQuery = true)
    List<Company> getTop5Company();

    @Query(value = "select * from company where status = 1", nativeQuery = true)
    List<Company> getListCompany();
}
