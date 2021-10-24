package codluck.training.demo.repository;

import codluck.training.demo.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LoginRepository extends JpaRepository<Login, Integer> {
    @Query(value = "select * from car.login where status = true and username =:name", nativeQuery = true)
     Login getAccountByUserName(@Param(value = "name") String name);

    @Query(value = "select * from login where status = true and username = :username", nativeQuery = true)
    List<Login> getLoginByUserName(@Param("username") String userName);

    @Query(value = "select count(*) from login where status = true and username = :username", nativeQuery = true)
    int getCountLoginByUserName(@Param("username") String username);

    @Modifying
    @Query(value="update login set status = false where user_Id =:id", nativeQuery = true)
    void deleteByIdWithAdmin(@Param(value = "id") int id);

    @Modifying
    @Query(value="update login set status = TRUE where user_Id =:userID", nativeQuery = true)
    void activeAccount(@Param(value = "userID") int userID);

    @Query(value = "select * from car.login where status = true and user_id =:id", nativeQuery = true)
    public Login getLoginByUserID(@Param(value = "id") int id);

    @Query(value = "select password from car.login where status = true and user_id =:id", nativeQuery = true)
    public String getPasswordByUserId(@Param(value = "id") int id);
}
