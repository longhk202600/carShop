package codluck.training.demo.service;

import codluck.training.demo.model.Car;
import codluck.training.demo.model.CarDetail;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CarService {

    List<Car> getTop12Car();

    void deleteAll();

    void deleteAll(List<Car> entities);

    void deleteAllById(List<Integer> ids);

    void delete(Car entity);

    void deleteById(Integer id);
    void changeUserId(int id, int idUser);

    void deleteById(int id);

    long count();

    List<Car> findAllById(List<Integer> ids);

    Iterable<Car> findAll();

    boolean existsById(Integer id);

    Car findCarById(Integer id);

    List<Car> saveAll(List<Car> entities);

    List<Car> getCarByCompanyId(int id);

    List<Car> getCarByCompanyId(int id, int carId);

    List<Car> findByStatusCar(Boolean Status);

    List<Car> findByNameContaining(String name);

    List<Car> findByNameCompanyContaining(String company);

    List<Car> sortCarByPriceASC();

    List<Car> sortCarByPriceDESC();

    List<Car> sortCarByNameASC();

    List<Car> getCarByUserId(int id);

    Car save(Car c);

    List<Car> getListfromCart(Object o, Car car);

    List<CarDetail> getCarInShowroomByUserId(int userId);

    List<CarDetail> getCarSoldInShowroomByUserId(int userId);

    List<CarDetail> getCarSoldInHistoryByUserId(int userId, int index);


    List<CarDetail> getCarInShowroomByUserIdLimit(int userId, int index);

    void saveCar(Car car, MultipartFile multipartFile, MultipartFile[] moreImageCar) throws IOException;

    Car getCarById(int id);

    boolean deleteCarById(int id);

    List<Car> getListCarFromUserOrder(int userId);

    StringBuilder getHtmlCarWithPage(List<CarDetail> carDetailList);

    List<CarDetail> getCarOrderLimit(int userId, int index);

    void updateCar(Car car, MultipartFile multipartFile, MultipartFile[] moreImageCar) throws IOException;

    StringBuilder getHtmlCarOrderWithPage(List<CarDetail> carDetailList);

    List<CarDetail> getCarOrder(int userId);


    int[] arrayPage(int totalItemCar);

    StringBuilder getHtmlCarSoldWithPage(List<CarDetail> carInShowroomByUserIdLimit);

    List<CarDetail> getCarSoldInShowroomByUserIdLimit(int userId, int index);
}
