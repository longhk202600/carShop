package codluck.training.demo.repository;

import codluck.training.demo.model.CarDetail;
import codluck.training.demo.model.ListOrder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListOrdersRepository extends JpaRepository<ListOrder, String> {
    @Query(value = "select o.id, t.name as car_name, c.name as username from car.car t, car.user c , car.orders o\n" +
            "where o.car_Id = t.id and o.user_Id=c.id and o.status = TRUE", nativeQuery = true)
    List<ListOrder> getListOrder();
    @Modifying
    @Query(value="update car.orders set status = false WHERE id = :id", nativeQuery = true)
    void deleteById(@Param(value = "id") int id);
}
