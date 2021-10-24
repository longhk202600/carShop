package codluck.training.demo.service.Impl;

import codluck.training.demo.model.Login;
import codluck.training.demo.repository.LoginRepository;
import codluck.training.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginRepository loginRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Login getAccountByUserName(String name) {
        return loginRepository.getAccountByUserName(name);
    }

    @Override
    public Login getLoginByUserName(String userName) {
        try {
            List<Login> loginList = loginRepository.getLoginByUserName(userName);
            if (loginList != null) {
                return loginList.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public String getPassword(int userID) {
        return loginRepository.getPasswordByUserId(userID);
    }
    @Override
    public void save(Login login) {
        login.setPassword(passwordEncoder.encode(login.getPassword()));
        loginRepository.save(login);
    }

    @Override
    public boolean getCountLoginByUserName(String userName) {
        return loginRepository.getCountLoginByUserName(userName) > 0;
    }

    @Override
    public void deleteByIdWithAdmin(int id) {
        loginRepository.deleteByIdWithAdmin(id);
    }

    @Override
    public Login getLoginByUserID(int userID) {
        return loginRepository.getLoginByUserID(userID);
    }

    @Override
    public void activeAccount(int UserID) {
        System.out.println(UserID);
        loginRepository.activeAccount(UserID);
    }
}
