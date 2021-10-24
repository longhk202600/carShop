package codluck.training.demo.repository;

import codluck.training.demo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query(value = "select * from orders where car_Id = :carId and" +
            " user_Id = :userid and  status = 1", nativeQuery = true)
    List<Order> getListOrderByUserIDAndCarID(@Param("carId") int carId, @Param("userid") int userid);

    @Modifying
    @Query(value = "update orders set status = FALSE where id = :orderID", nativeQuery = true)
    void deleteById(@Param("orderID") int orderID);

    @Modifying
    @Query(value = "update orders set status = FALSE where car_Id = :carID", nativeQuery = true)
    void deleteOrderByCarID(int carID);
}
