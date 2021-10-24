package codluck.training.demo.service.Impl;

import codluck.training.demo.model.Car;
import codluck.training.demo.model.Company;
import codluck.training.demo.repository.CompanyRepository;
import codluck.training.demo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    @Override
    public List<Company> getTop5Company() {
        return companyRepository.getTop5Company();
    }

    @Override
    public void deleteAll() {
    }

    @Override
    public void deleteAll(List<Company> entities) {
    }

    @Override
    public void deleteAllById(List<Integer> ids) {
    }

    @Override
    public void delete(Company entity) {
    }

    @Override
    public void deleteById(Integer id) {
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public List<Company> findAllById(List<Integer> ids) {
        return null;
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public boolean existsById(Integer id) {
        return false;
    }

    @Override
    public Optional<Company> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Company> saveAll(List<Company> entities) {
        return null;
    }

    @Override
    public Car save(Company c) {
        return null;
    }

    @Override
    public List<Company> getListCompany() {
        return companyRepository.getListCompany();
    }
}
