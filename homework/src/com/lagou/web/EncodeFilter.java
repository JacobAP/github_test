package com.lagou.web;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author jacob
 * @Date 2020/12/12 23:13
 * @Version 1.0
 */
public class EncodeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        if ("post".equalsIgnoreCase(req.getMethod())) req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        //System.out.println("编码设置完成，开始登录servlet");
        filterChain.doFilter(req, resp);

    }

    @Override
    public void destroy() {

    }
}
