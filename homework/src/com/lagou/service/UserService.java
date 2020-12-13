package com.lagou.service;

import com.lagou.domain.User;

import java.sql.SQLException;

/**
 * @Author jacob
 * @Date 2020/12/12 23:19
 * @Version 1.0
 */
public interface UserService {

    public abstract User login(String username, String password) throws SQLException;

    public abstract void addUser(User user) throws SQLException;

}
