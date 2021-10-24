package codluck.training.demo.repository;

import codluck.training.demo.model.Showroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShowroomRepository extends JpaRepository<Showroom, Integer> {
    @Query(value = "select * from car.showroom where status = true and user_Id =:id", nativeQuery = true)
    public Showroom getShowroomByUserID(@Param(value = "id") int id);

    @Query(value = "select * from showroom where user_Id = :userId and status = 1", nativeQuery = true)
    Showroom getShowroomByUserId(@Param("userId") int userId);

    @Query(value = "select * from showroom where id = :id and status = 1", nativeQuery = true)
    Showroom getShowroomById(@Param("id") int id);

    @Query(value = "select * from car.showroom where status = true",nativeQuery = true)
    public Iterable<Showroom> findAllAA();

    @Modifying
    @Query(value="update car.showroom set status = false WHERE id = :id", nativeQuery = true)
    void deleteById(@Param(value = "id") int id);
}
