package codluck.training.demo.service;

import codluck.training.demo.model.Car;
import codluck.training.demo.model.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    List<Company> getTop5Company();

    void deleteAll();

    void deleteAll(List<Company> entities);

    void deleteAllById(List<Integer> ids);

    void delete(Company entity);

    void deleteById(Integer id);

    long count();

    List<Company> findAllById(List<Integer> ids);

    List<Company> findAll();

    boolean existsById(Integer id);

    Optional<Company> findById(Integer id);

    List<Company> saveAll(List<Company> entities);

    Car save(Company c);

    List<Company> getListCompany();
}
