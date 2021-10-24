package codluck.training.demo.service.Impl;

import codluck.training.demo.model.Car;
import codluck.training.demo.model.CarDetail;
import codluck.training.demo.model.Image;
import codluck.training.demo.repository.CarDetailRepository;
import codluck.training.demo.repository.CarRepository;
import codluck.training.demo.repository.ImageRepository;
import codluck.training.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public List<Car> getCarByUserId(int id) {
        return carRepository.getCarByUserId(id);
    }

    @Override
    public void saveCar(Car car, MultipartFile multipartFile, MultipartFile[] moreImageCar) throws IOException {
        if (multipartFile.isEmpty()) {
            car.setImagepath(car.getImagepath());
            carRepository.saveAndFlush(car);
        } else {
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
            car.setImagepath(imagePath.resolve(multipartFile.getOriginalFilename()).toString());
            carRepository.saveAndFlush(car);
        }
        // save more car image to database
        if (moreImageCar.length != 0) {
            for (MultipartFile imageCar : moreImageCar) {
                Image image = new Image();
                Path staticPath = Paths.get("static");
                Path imagePath = Paths.get("image");
                if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
                    Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
                }
                Path file = CURRENT_FOLDER.resolve(staticPath)
                        .resolve(imagePath).resolve(imageCar.getOriginalFilename());
                try (OutputStream os = Files.newOutputStream(file)) {
                    os.write(imageCar.getBytes());
                }
                image.setImage(imagePath.resolve(imageCar.getOriginalFilename()).toString());
                image.setCarId(car.getId());
                imageRepository.save(image);
            }
        }
    }

    @Override
    public List<CarDetail> getCarInShowroomByUserIdLimit(int userId, int index) {
        return carDetailRepository.getCarInShowroomByUserIdLimit(userId, index);
    }

    @Override
    public List<CarDetail> getCarSoldInShowroomByUserIdLimit(int userId, int index) {
        return carDetailRepository.getCarSoldInShowroomByUserIdLimit(userId, index);
    }

    @Override
    public Car save(Car st) {
        return carRepository.save(st);
    }

    @Override
    public List<Car> getListfromCart(Object o, Car car) {
        List<Car> list;
        if (o != null) {
            list = (List<Car>) o;
        } else {
            list = new ArrayList<>();
        }
        boolean check = false;
        try {
            for (Car i : list) {
                if (i.getId() == car.getId()) {
                    check = true;
                }
            }
            if (!check) {
                list.add(car);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error in add cart");
        }
        return list;
    }

    @Override
    public List<Car> saveAll(List<Car> entities) {
        return carRepository.saveAll(entities);
    }

    @Override
    public List<Car> getCarByCompanyId(int id, int carId) {
        return carRepository.getCarByCompanyId(id, carId);
    }

    @Override
    public List<Car> getCarByCompanyId(int id) {
        return carRepository.getCarByCompanyId(id);
    }

    @Override
    public List<Car> findByStatusCar(Boolean status) {
        return carRepository.findByStatus_Car(status);
    }

    @Override
    public List<Car> findByNameContaining(String name) {
        return carRepository.findByNameContaining(name);
    }

    @Override
    public List<Car> findByNameCompanyContaining(String company) {
        return carRepository.findByNameCompanyContaining(company);
    }

    @Override
    public List<Car> sortCarByPriceASC() {
        return carRepository.sortCarByPriceASC();
    }

    @Override
    public List<Car> sortCarByPriceDESC() {
        return carRepository.sortCarByPriceDESC();
    }

    @Override
    public List<Car> sortCarByNameASC() {
        return carRepository.sortCarByNameASC();
    }

    @Override
    public boolean existsById(Integer id) {
        return carRepository.existsById(id);
    }

    @Override
    public Car findCarById(Integer id) {
        return carRepository.findCarById(id);
    }

    @Override
    public Iterable<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> findAllById(List<Integer> ids) {
        return (List<Car>) carRepository.findAllById(ids);
    }

    @Override
    public long count() {
        return carRepository.count();
    }

    @Override
    public void deleteById(Integer id) {
        carRepository.deleteById(id);
    }

    @Override
    public void changeUserId(int id, int idUser) {
        carRepository.changeUserCar(id,idUser);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        try {
            carRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void delete(Car entity) {
        carRepository.delete(entity);
    }

    @Override
    @Transactional
    public void deleteAllById(List<Integer> ids) {
        carRepository.deleteAllById(ids);
    }

    @Override
    @Transactional
    public void deleteAll(List<Car> entities) {
        carRepository.deleteAll(entities);
    }

    @Override
    public List<Car> getTop12Car() {
        return carRepository.getTop12Car();
    }

    @Override
    public void deleteAll() {
        carRepository.deleteAll();
    }

    @Autowired
    CarDetailRepository carDetailRepository;

    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));

    @Override
    public List<CarDetail> getCarInShowroomByUserId(int userId) {
        return carDetailRepository.getCarInShowroomByUserId(userId);
    }

    @Override
    public List<CarDetail> getCarSoldInShowroomByUserId(int userId) {
        return carDetailRepository.getCarSoldInShowroomByUserId(userId);
    }

    @Override
    public List<CarDetail> getCarSoldInHistoryByUserId(int userId, int index) {
        return carDetailRepository.getCarSoldInHistoryByUserId(userId,index);
    }

    @Override
    public Car getCarById(int id) {
        return carRepository.getCarById(id);
    }

    @Override
    @Transactional
    public boolean deleteCarById(int id) {
        try {
            carRepository.deleteCarById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Car> getListCarFromUserOrder(int userId) {
        return carRepository.getListCarFromUserOrder(userId);
    }

    @Override
    public StringBuilder getHtmlCarOrderWithPage(List<CarDetail> carDetailList) {
        StringBuilder html = new StringBuilder("");
        for (CarDetail carDetail : carDetailList) {
            if (carDetail.getUsage()) {
                html.append("<tr>");
                html.append("<td><img src=" + carDetail.getImagePath() + " alt=\"ảnh xe\" height=\"150px\" width=\"150px\"></td>");
                html.append("<td>" + carDetail.getName() + "</td>");
                html.append("<td>" + carDetail.getCompanyName() + "</td>");
                html.append("<td>" + carDetail.getType() + "</td>");
                html.append("<td>" + carDetail.getColor() + "</td>");
                html.append("<td>" + carDetail.getSeats() + "</td>");
                html.append("<td>Mới</td>");
                html.append("<td>" + carDetail.getPriceFrom() + "</td>");
                html.append("<td>" + carDetail.getPriceTo() + "</td>");
                html.append("<td>" + carDetail.getInformation() + "</td>");
                html.append("<td>\n" +
                        "                <a href=/listOrder?id=" + carDetail.getId() + " class=\"btn btn-warning\">\n" +
                        "                    Xem người đặt\n" +
                        "                </a>\n" +
                        "            </td>");
                html.append("</tr>");
            } else {
                html.append("<tr>");
                html.append("<td><img src=" + carDetail.getImagePath() + " alt=\"ảnh xe\" height=\"150px\" width=\"150px\"></td>");
                html.append("<td>" + carDetail.getName() + "</td>");
                html.append("<td>" + carDetail.getCompanyName() + "</td>");
                html.append("<td>" + carDetail.getType() + "</td>");
                html.append("<td>" + carDetail.getColor() + "</td>");
                html.append("<td>" + carDetail.getSeats() + "</td>");
                html.append("<td>Cũ</td>");
                html.append("<td>" + carDetail.getPriceFrom() + "</td>");
                html.append("<td>" + carDetail.getPriceTo() + "</td>");
                html.append("<td>" + carDetail.getInformation() + "</td>");
                html.append("<td>\n" +
                        "                <a href=/listOrder?id=" + carDetail.getId() + " class=\"btn btn-warning\">\n" +
                        "                    Xem người đặt\n" +
                        "                </a>\n" +
                        "            </td>");
                html.append("</tr>");
            }

        }
        return html;
    }

    public StringBuilder getHtmlCarWithPage(List<CarDetail> carDetailList) {
        StringBuilder html = new StringBuilder("");
        for (CarDetail carDetail : carDetailList) {
            if (carDetail.getUsage()) {
                html.append("<tr>");
                html.append("<td><img src=" + carDetail.getImagePath() + " alt=\"ảnh xe\" height=\"150px\" width=\"150px\"></td>");
                html.append("<td>" + carDetail.getName() + "</td>");
                html.append("<td>" + carDetail.getCompanyName() + "</td>");
                html.append("<td>" + carDetail.getType() + "</td>");
                html.append("<td>" + carDetail.getColor() + "</td>");
                html.append("<td>" + carDetail.getSeats() + "</td>");
                html.append("<td>Mới</td>");
                if(carDetail.getStatusCar()){
                    html.append("<td>Xe Đang Bán</td>");
                }else{
                    html.append("<td>Xe Không Bán</td>");
                }
                html.append("<td>" + carDetail.getPriceFrom() + "</td>");
                html.append("<td>" + carDetail.getPriceTo() + "</td>");
                html.append("<td>" + carDetail.getInformation() + "</td>");
                html.append("<td>\n" +
                        "                <a href=/edit-car?id=" + carDetail.getId() + " class=\"btn btn-warning\" {\n" +
                        "                >\n" +
                        "                    <i class=\"far fa-edit\"></i>\n" +
                        "                </a>\n" +
                        "                <a href=/delete-car?id=" + carDetail.getId() + " class=\"delete btn btn-danger\"\n" +
                        "                   data-confirm=\"Bạn có chắc chắn muốn xóa xe này\">\n" +
                        "                    <i class=\"far fa-trash-alt\"></i>\n" +
                        "                </a>\n" +
                        "            </td>");
                html.append("</tr>");
            } else {
                html.append("<tr>");
                html.append("<td><img src=" + carDetail.getImagePath() + " alt=\"ảnh xe\" height=\"150px\" width=\"150px\"></td>");
                html.append("<td>" + carDetail.getName() + "</td>");
                html.append("<td>" + carDetail.getCompanyName() + "</td>");
                html.append("<td>" + carDetail.getType() + "</td>");
                html.append("<td>" + carDetail.getColor() + "</td>");
                html.append("<td>" + carDetail.getSeats() + "</td>");
                html.append("<td>Cũ</td>");
                if(carDetail.getStatusCar()){
                    html.append("<td>Xe Đang Bán</td>");
                }else{
                    html.append("<td>Xe Không Bán</td>");
                }
                html.append("<td>" + carDetail.getPriceFrom() + "</td>");
                html.append("<td>" + carDetail.getPriceTo() + "</td>");
                html.append("<td>" + carDetail.getInformation() + "</td>");
                html.append("<td>\n" +
                        "                <a href=/edit-car?id=" + carDetail.getId() + " class=\"btn btn-warning\" {\n" +
                        "                >\n" +
                        "                    <i class=\"far fa-edit\"></i>\n" +
                        "                </a>\n" +
                        "                <a href=/delete-car?id=" + carDetail.getId() + " class=\"delete btn btn-danger\"\n" +
                        "                   data-confirm=\"Bạn có chắc chắn muốn xóa xe này\">\n" +
                        "                    <i class=\"far fa-trash-alt\"></i>\n" +
                        "                </a>\n" +
                        "            </td>");
                html.append("</tr>");
            }
        }
        return html;
    }

    @Override
    public List<CarDetail> getCarOrderLimit(int userId, int index) {
        return carDetailRepository.getCarOrderLimit(userId, index);
    }

    @Override
    public List<CarDetail> getCarOrder(int userId) {
        return carDetailRepository.getCarOrder(userId);
    }

    @Override
    @Transactional
    public void updateCar(Car car,
                          MultipartFile multipartFile,
                          MultipartFile[] moreImageCar) throws IOException {
        if (multipartFile.isEmpty()) {
            car.setImagepath(car.getImagepath());
        } else {
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
            car.setImagepath(imagePath.resolve(multipartFile.getOriginalFilename()).toString());
        }
        carRepository.saveAndFlush(car);
        // save more car image to database
        if (moreImageCar.length != 1) {
            List<Image> imageMoreList = imageRepository.getImageByCarId(car.getId());
            int temp = 0;
            for (MultipartFile imageCar : moreImageCar) {
                int imageId;
                for (int i = temp; i < imageMoreList.size(); i++) {
                    imageId = imageMoreList.get(i).getId();
                    Image image = new Image();
                    Path staticPath = Paths.get("static");
                    Path imagePath = Paths.get("image");
                    if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
                        Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
                    }
                    Path file = CURRENT_FOLDER.resolve(staticPath)
                            .resolve(imagePath).resolve(imageCar.getOriginalFilename());
                    try (OutputStream os = Files.newOutputStream(file)) {
                        os.write(imageCar.getBytes());
                    }
                    image.setImage(imagePath.resolve(imageCar.getOriginalFilename()).toString());
                    image.setCarId(car.getId());
                    image.setId(imageId);
                    imageRepository.updateImage(image.getImage(), imageId);
                    temp = i + 1;
                    break;
                }
            }
        }
    }

    public int[] arrayPage(int totalItemCar) {
        int totalPageCar = (int) Math.ceil((double) totalItemCar / 6);
        int array[] = new int[totalPageCar];
        for (int i = 0; i < totalPageCar; i++) {
            array[i] = i;
        }
        return array;
    }

    @Override
    public StringBuilder getHtmlCarSoldWithPage(List<CarDetail> carSoldDetailList) {
        StringBuilder html = new StringBuilder("");
        for (CarDetail carDetail : carSoldDetailList) {
            if (carDetail.getUsage()) {
                html.append("<tr>");
                html.append("<td><img src=" + carDetail.getImagePath() + "" +
                        " alt=\"ảnh xe\" height=\"150px\" width=\"150px\"></td>");
                html.append("<td>" + carDetail.getName() + "</td>");
                html.append("<td>" + carDetail.getCompanyName() + "</td>");
                html.append("<td>" + carDetail.getType() + "</td>");
                html.append("<td>" + carDetail.getColor() + "</td>");
                html.append("<td>" + carDetail.getSeats() + "</td>");
                html.append("<td>Mới</td>");
                html.append("<td>" + carDetail.getPriceFrom() + "</td>");
                html.append("<td>" + carDetail.getPriceTo() + "</td>");
                html.append("<td>" + carDetail.getInformation() + "</td>");
                html.append("<td>\n" +
                        "                <a href=/edit-car?id=" + carDetail.getId() + " class=\"btn btn-warning\" {\n" +
                        "                >\n" +
                        "                    <i class=\"far fa-edit\"></i>\n" +
                        "                </a>\n" +
                        "                <a href=/delete-car?id=" + carDetail.getId() + " " +
                        "class=\"delete btn btn-danger\"\n" +
                        "                   data-confirm=\"Bạn có chắc chắn muốn xóa xe này\">\n" +
                        "                    <i class=\"far fa-trash-alt\"></i>\n" +
                        "                </a>\n" +
                        "            </td>");
                html.append("</tr>");
            } else {
                html.append("<tr>");
                html.append("<td><img src=" + carDetail.getImagePath() + "" +
                        " alt=\"ảnh xe\" height=\"150px\" width=\"150px\"></td>");
                html.append("<td>" + carDetail.getName() + "</td>");
                html.append("<td>" + carDetail.getCompanyName() + "</td>");
                html.append("<td>" + carDetail.getType() + "</td>");
                html.append("<td>" + carDetail.getColor() + "</td>");
                html.append("<td>" + carDetail.getSeats() + "</td>");
                html.append("<td>Cũ</td>");
                html.append("<td>" + carDetail.getPriceFrom() + "</td>");
                html.append("<td>" + carDetail.getPriceTo() + "</td>");
                html.append("<td>" + carDetail.getInformation() + "</td>");
                html.append("<td>\n" +
                        "                <a href=/edit-car?id=" + carDetail.getId() + " class=\"btn btn-warning\" {\n" +
                        "                >\n" +
                        "                    <i class=\"far fa-edit\"></i>\n" +
                        "                </a>\n" +
                        "                <a href=/delete-car?id=" + carDetail.getId() + " " +
                        "class=\"delete btn btn-danger\"\n" +
                        "                   data-confirm=\"Bạn có chắc chắn muốn xóa xe này\">\n" +
                        "                    <i class=\"far fa-trash-alt\"></i>\n" +
                        "                </a>\n" +
                        "            </td>");
                html.append("</tr>");
            }

        }
        return html;
    }
}
