package com.lagou.web;

import com.lagou.domain.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author jacob
 * @Date 2020/12/12 23:11
 * @Version 1.0
 */
public class CheckFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");

        if (null != user) {
            filterChain.doFilter(req, servletResponse);
        } else {
            servletResponse.getWriter().write("当前未登录。");
        }
    }

    @Override
    public void destroy() {

    }
}
