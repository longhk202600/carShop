package codluck.training.demo.service;

import codluck.training.demo.model.Login;
import codluck.training.demo.model.User;

import java.util.List;

public interface UserService {
    int save(User user, Login login);

    boolean edit(User user, Login login);

    Iterable<User> findAllExits();

    User getUserByID(int userId);

    void deleteById(int id);

    List<User> getListUserByCarID(int carId);

    User getUserByEmail(String email);
}
