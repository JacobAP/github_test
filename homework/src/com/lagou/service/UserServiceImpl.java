package com.lagou.service;

import com.lagou.dao.UserDao;
import com.lagou.dao.UserDaoImpl;
import com.lagou.domain.User;

import java.sql.SQLException;

/**
 * @Author jacob
 * @Date 2020/12/12 23:25
 * @Version 1.0
 */
public class UserServiceImpl implements UserService {
    @Override
    public User login(String username, String password) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        System.out.println("userService调用userDao的login方法，，，");
        User user = userDao.login(username, password);
        return user;
    }

    @Override
    public void addUser(User user) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        userDao.addUser(user);
    }
}
