package codluck.training.demo.service.Impl;

import codluck.training.demo.model.Login;
import codluck.training.demo.model.User;
import codluck.training.demo.repository.UserRepository;
import codluck.training.demo.service.LoginService;
import codluck.training.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @version 1.1 8/27/2021
 * @author: QuocDA
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoginService loginService;

    @Override
    public Iterable<User> findAllExits() {
        return userRepository.findAllExit();
    }

    @Override
    @Transactional
    public int save(User user, Login login) {
        try {
            if (userRepository.getCountUserByEmail(user.getEmail()) != 0) {
                return 2;
            }
            if (loginService.getCountLoginByUserName(login.getUsername())) {
                return 3;
            }
            if (!loginService.getCountLoginByUserName(login.getUsername()) &&
                    userRepository.getCountUserByEmail(user.getEmail()) == 0) {
                userRepository.saveAndFlush(user);
                login.setUserId(user.getId());
                loginService.save(login);
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    @Transactional
    public boolean edit(User user, Login login) {
        try {
            userRepository.saveAndFlush(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteByIdWithAdmin(id);
    }

    @Override
    public User getUserByID(int userId) {
        return userRepository.getById(userId);
    }

    @Override
    public List<User> getListUserByCarID(int carId) {
        return userRepository.getListUserByCarID(carId);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }
}
