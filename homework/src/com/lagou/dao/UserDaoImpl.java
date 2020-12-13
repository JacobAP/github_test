package com.lagou.dao;

import com.lagou.domain.User;
import com.lagou.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @Author jacob
 * @Date 2020/12/12 23:27
 * @Version 1.0
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User login(String username, String password) throws SQLException {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        System.out.println("开始查询");
        String sql = "select * from user where username = ? and password = ?";
        Object[] params = {username, password};
        System.out.println(params.toString());
        User user = qr.query(sql, new BeanHandler<>(User.class), params);
        return user;
    }

    @Override
    public void addUser(User user) throws SQLException {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "insert into user(user_id, username, sex, birthday) values(?, ?, ?, ?)";
        Object[] params = {user.getUserId(), user.getUserName(), user.getGender(), user.getBirthday()};
        qr.update(sql, params);
    }
}
