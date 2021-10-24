package codluck.training.demo.repository;

import codluck.training.demo.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

    @Query(value = "select u.id , l.username ,l.password, r.name,u.status" +
            " from User u join login l on l.user_Id = u.id join role r on " +
            "r.id = u.role_Id where u.status = true and l.username =:name", nativeQuery = true)
    Optional<UserRole> getAccountByUserName(@Param(value = "name") String name);
}
