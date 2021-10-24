package codluck.training.demo.repository;

import codluck.training.demo.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query(value = "select * from car.car where status = true and status_Car = TRUE  order by id desc limit 12;", nativeQuery = true)
    List<Car> getTop12Car();

    @Query(value = "select * from car.car where status = true and status_Car = TRUE  and company_Id =:id", nativeQuery = true)
    List<Car> getCarByCompanyId(@Param(value = "id") int id);

    @Query(value = "select * from car.car where status = true and status_Car = TRUE  and company_Id =:id and id != :Car_id limit 8 ",
            nativeQuery = true)
    List<Car> getCarByCompanyId(@Param(value = "id") int id, @Param(value = "Car_id") int Car_id);

    @Query(value = "select * from car.car where car.usage =:status and status =1 and status_Car = TRUE ", nativeQuery = true)
    List<Car> findByStatus_Car(@Param(value = "status") Boolean status);

    @Query(value = "select * from car  where status=true and status_Car = TRUE and name like %:input%", nativeQuery = true)
    List<Car> findByNameContaining(@Param(value = "input") String status);

    @Query(value = "select c.id,c.user_Id,c.company_Id,c.name,c.image_Path,c.price_From,c.price_To,c.information" +
            ",c.status_Car,c.color,c.type,c.seats,c.phone,c.usage,c.status from `car`c  left join company cm" +
            " on c.company_Id = cm.id where cm.name_Company like %:input% and c.status = TRUE and status_Car = TRUE ", nativeQuery = true)
    List<Car> findByNameCompanyContaining(@Param(value = "input") String status);

    @Query(value = "select * from car.car where status = true and status_Car = TRUE  order by price_From asc limit 12;", nativeQuery = true)
    List<Car> sortCarByPriceASC();

    @Query(value = "select * from car.car where status = true and status_Car = TRUE  order by price_From desc limit 12;", nativeQuery = true)
    List<Car> sortCarByPriceDESC();

    @Query(value = "select * from car.car where status = true and status_Car = TRUE  order by name asc limit 12;", nativeQuery = true)
    List<Car> sortCarByNameASC();


    @Query(value = "select o.id,c.user_Id,c.company_Id,c.name,c.image_Path,c.price_From,c.price_To,c.information," +
            "c.status_Car,c.color,c.type,c.seats,c.phone,c.usage,c.status from `car` c join orders o" +
            " ON c.id=o.car_Id where status=true and status_Car = TRUE  o.user_Id =:userID and o.status =1", nativeQuery = true)
    public List<Car> getListCarFromUserOrder(@Param(value = "userID") int userID);

    @Query(value = "select * from car.car where status = true and status_Car = TRUE  and user_Id =:id", nativeQuery = true)
    List<Car> getCarByUserId(@Param(value = "id") int id);

    //phần của quốc
    @Query(value = "select * from car where user_Id = :userId and status = 1 and status_Car = TRUE ", nativeQuery = true)
    List<Car> getListCarByUserId(@Param("userId") int userId);

    @Query(value = "select * from car where id = :id and status = 1 and status_Car = TRUE ", nativeQuery = true)
    Car getCarById(@Param("id") int id);

    @Modifying
    @Query(value = "update car set status_Car = 0 where id = :id ", nativeQuery = true)
    void deleteCarById(@Param("id") int id);

    @Modifying
    @Query(value = "update car set user_Id = :idUser , status_Car = 0  where id = :id", nativeQuery = true)
    void changeUserCar(@Param("id") int id,@Param("idUser") int idUser);


    @Modifying
    @Query(value = "UPDATE car set status_Car = FALSE where  id = :CarID and status = 1", nativeQuery = true)
    void deleteById(@Param("CarID") int CarID);

    @Query(value = "SELECT * FROM car.car where status = true and id=:id and status_Car = TRUE ", nativeQuery = true)
    Car findCarById(@Param(value = "id") int id);

}
