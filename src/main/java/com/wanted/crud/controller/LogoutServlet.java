package com.wanted.crud.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //세션 만료 처리(요구사항: session.incalidate())
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        //메인 페이지로
        resp.sendRedirect(req.getContextPath() + "/");
    }
}
