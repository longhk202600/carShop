package codluck.training.demo.repository;

import codluck.training.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select * from car.user where status = true ", nativeQuery = true)
     List<User> findAllExit();

    @Query(value = "select u.id,u.name,u.role_Id, u.email,u.phone," +
            "u.address,u.status from car.orders o Join user u on u.id=o.user_Id " +
            "where o.car_Id=:id and o.status=TRUE", nativeQuery = true)
     List<User> getListUserByCarID(@Param(value = "id") int id);

    @Query(value = "select * from car.user where email =:email and status =TRUE; ", nativeQuery = true)
     User getUserByEmail(@Param(value = "email") String email);

    @Modifying
    @Query(value = "update user set status = false where id = :id", nativeQuery = true)
    void deleteByIdWithAdmin(@Param(value = "id") int id);

    @Query(value = "select count(*) from user where email = :email and status = 1", nativeQuery = true)
    int getCountUserByEmail(@Param("email") String email);
}
