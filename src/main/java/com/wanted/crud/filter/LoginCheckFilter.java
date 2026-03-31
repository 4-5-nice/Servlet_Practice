package com.wanted.crud.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

// /employees로 시작하는 모든 요청을 가로챔!
@WebFilter("/employees/*")
public class LoginCheckFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("loginUser") == null) {
            // 로그인 안 됐으면 메인으로 튕겨내기
            resp.sendRedirect(req.getContextPath() + "/");
        } else {
            // 로그인 됐으면 원래 가려던 길 가게 해주기
            chain.doFilter(request, response);
        }
    }
}
