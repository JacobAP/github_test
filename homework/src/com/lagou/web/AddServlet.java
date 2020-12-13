package com.lagou.web;

import com.lagou.domain.User;
import com.lagou.service.UserService;
import com.lagou.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

/**
 * @Author jacob
 * @Date 2020/12/12 23:10
 * @Version 1.0
 */
public class AddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String userName = req.getParameter("userName");
        String passWord = req.getParameter("passWord");
        String gender = req.getParameter("gender");
        Date birthday = Date.valueOf(req.getParameter("birthday"));
        User user = new User(userId, userName, passWord, gender, birthday);
        UserService userService = new UserServiceImpl();
        try {
            userService.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.getWriter().write("新增用户成功。");

    }
}
