package com.lagou.web;

import com.lagou.domain.User;
import com.lagou.service.UserService;
import com.lagou.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Author jacob
 * @Date 2020/12/12 23:11
 * @Version 1.0
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserService userService = new UserServiceImpl();
        try {
            System.out.println("开始调用login方法，，，");
            User user = userService.login(username, password);
            if (null != user) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                resp.sendRedirect("success.html");
            } else {
                resp.getWriter().write("用户名或密码错误，登录失败。");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
