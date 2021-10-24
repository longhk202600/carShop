package codluck.training.demo.service;

import codluck.training.demo.model.Login;

public interface LoginService {
    Login getAccountByUserName(String name);

    void save(Login login);

    Login getLoginByUserName(String userName);

    boolean getCountLoginByUserName(String userName);

    void deleteByIdWithAdmin(int id);

    Login getLoginByUserID(int userID);

    void activeAccount(int UserID);

    String getPassword(int userdID);
}
