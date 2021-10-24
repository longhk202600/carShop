package codluck.training.demo.repository;

import codluck.training.demo.model.PostOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostOrderRepository extends JpaRepository<PostOrder,Integer> {
    @Query(value = "select * from car.postorder where status = true ",nativeQuery = true)
     Iterable<PostOrder> findAllExít();

}
