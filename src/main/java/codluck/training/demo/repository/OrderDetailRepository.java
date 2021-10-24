package codluck.training.demo.repository;

import codluck.training.demo.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetails, String> {
    @Query(value = "select po.car_Description, po.price_From, po.price_To, po.image, po.seats, po.more_Description," +
            " po.car_Usage, u.name, u.email, u.phone, u.address from postorder po \n" +
            "inner join user u on po.user_Id = u.id where po.status = 1 and u.status = 1 order by po.id desc",
            nativeQuery = true)
    List<OrderDetails> getOrderDetail();

    @Query(value = "select po.car_Description, po.price_From, po.price_To, po.image, po.seats, po.more_Description," +
            " po.car_Usage, u.name, u.email, u.phone, u.address from postorder po \n" +
            "inner join user u on po.user_Id = u.id where po.status = 1 and u.status = 1 order by po.id desc limit :index,6", nativeQuery = true)
    List<OrderDetails> getOrderDetailLimit(@Param("index") int index);
}
