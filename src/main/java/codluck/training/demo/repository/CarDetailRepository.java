package codluck.training.demo.repository;

import codluck.training.demo.model.CarDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarDetailRepository extends JpaRepository<CarDetail, Integer> {

    @Query(value = "select c.id, c.name, c.image_Path, c.price_From," +
            " c.price_To, c.information, c.color, c.type, c.seats," +
            " c.usage, co.name_Company from car c inner join company co on c.company_Id = co.id " +
            "where c.user_Id = :userId and c.status_Car = 1 limit 6", nativeQuery = true)
    List<CarDetail> getCarInShowroomByUserIdLimit(@Param("userId") int userId);

    //phần của quốc
    @Query(value = "select c.id, c.name, c.image_Path, c.price_From, c.price_To, c.information, c.color, c.type, c.seats," +
            " c.usage, co.name_Company,c.status_Car from car c inner join company co on c.company_Id = co.id " +
            "where c.user_Id = :userId and c.status = 1 and co.status = 1 order by c.id desc", nativeQuery = true)
    List<CarDetail> getCarInShowroomByUserId(@Param("userId") int userId);

    @Query(value = "select c.id, c.name, c.image_Path, c.price_From, c.price_To, c.information, c.color, c.type, c.seats," +
            " c.usage, co.name_Company,c.status_Car from car c inner join company co on c.company_Id = co.id " +
            "where c.user_Id = :userId and co.status = 1 order by c.id desc limit :index,6", nativeQuery = true)
    List<CarDetail> getCarInShowroomByUserIdLimit(@Param("userId") int userId, @Param("index") int index);

    @Query(value = "select DISTINCT c.id, c.name, c.image_Path, c.price_From, c.price_To, c.information, c.color, c.type, c.seats,\n" +
            "             c.usage, co.name_Company,c.status_Car from car c inner join orders ord on c.id = ord.car_Id\n" +
            "             inner join company co on c.company_Id = co.id\n" +
            "            where c.user_Id = :userId and c.status = 1 and co.status = 1 and ord.status = 1 " +
            "order by c.id desc limit :index,6", nativeQuery = true)
    List<CarDetail> getCarOrderLimit(@Param("userId") int userId, @Param("index") int index);

    @Query(value = "select DISTINCT c.id, c.name, c.image_Path, c.price_From, c.price_To, c.information, c.color, c.type, c.seats,\n" +
            "             c.usage, co.name_Company,c.status_Car from car c inner join orders ord on c.id = ord.car_Id\n" +
            "             inner join company co on c.company_Id = co.id\n" +
            "            where c.user_Id = :userId and c.status = 1 and co.status = 1 and ord.status = 1 " +
            "order by c.id desc", nativeQuery = true)
    List<CarDetail> getCarOrder(@Param("userId") int userId);

    @Query(value = "select c.id, c.name, c.image_Path, c.price_From," +
            " c.price_To, c.information, c.color, c.type, c.seats," +
            " c.usage, co.name_Company,c.status_Car from car c inner join company co on c.company_Id = co.id " +
            "where c.user_Id = :userId and c.status_Car = 0 limit 6", nativeQuery = true)
    List<CarDetail> getCarSoldInShowroomByUserIdLimit(@Param("userId") int userId);
//
//    @Query(value = "select c.id, c.name, c.image_Path, c.price_From, c.price_To, c.information, c.color, c.type, c.seats," +
//            " c.usage, co.name_Company from car c inner join company co on c.company_Id = co.id " +
//            "where c.user_Id = :userId and c.status_Car = 0 and co.status = 1 order by c.id desc limit :index,6", nativeQuery = true)
//    List<CarDetail> getCarSoldInShowroomByUserIdLimit(@Param("userId") int userId, @Param("index") int index);
    @Query(value = "select c.id, c.name, c.image_Path, c.price_From, c.price_To, c.information, c.color, c.type, c.seats," +
            " c.usage, co.name_Company,c.status_Car from historytrade t, car c inner join company co on c.company_Id = co.id " +
            "where t.user_Id_Partner =:userId and t.car_Id=c.id and co.status = 1 order by c.id desc limit :index,6", nativeQuery = true)
    List<CarDetail> getCarSoldInShowroomByUserIdLimit(@Param("userId") int userId, @Param("index") int index);

    @Query(value = "select c.id, c.name, c.image_Path, c.price_From, c.price_To, c.information, c.color, c.type, c.seats," +
            " c.usage, co.name_Company,c.status_Car from historytrade t, car c inner join company co on c.company_Id = co.id " +
            "where t.user_Id_Partner =:userId and t.car_Id=c.id and co.status = 1 order by c.id desc limit :index,6", nativeQuery = true)
    List<CarDetail> getCarSoldInHistoryByUserId(@Param("userId") int userId, @Param("index") int index);


    @Query(value = "select c.id, c.name, c.image_Path, c.price_From, c.price_To, c.information, c.color, c.type, c.seats," +
            " c.usage, co.name_Company,c.status_Car from historytrade t, car c inner join company co on c.company_Id = co.id " +
            "where t.user_Id_Partner =:userId and t.car_Id=c.id and co.status = 1 order by c.id desc", nativeQuery = true)
    List<CarDetail> getCarSoldInShowroomByUserId(@Param("userId") int userId);
}
