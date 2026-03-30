package com.wanted.crud.controller;

import com.wanted.crud.dao.LoginDAO;
import com.wanted.crud.service.LoginService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private LoginService inService = new LoginService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        String userId = req.getParameter("userId");
        String userPwd = req.getParameter("userPwd");

        //임시 로그인 확인
        if ("admin".equals(userId) || "user".equals(userId)) {
            if ("1234".equals(userPwd)) {
                loginSuccess(req, resp, userId);
            } else {
                // 임시 계정인데 비번이 1234가 아니면 여기서 에러!
                showError(req, resp, "임시 계정 비밀번호가 틀렸습니다.");
            }
            return;
        }

        //임시 계정이 아니라면
        String dbUserId = inService.selectUser(userId);
        if (dbUserId != null) {
            // 아이디가 존재하면 바로 로그인 성공!
            loginSuccess(req, resp, dbUserId);
        } else {
            // 아이디가 없으면 에러
            showError(req, resp, "존재하지 않는 아이디입니다.");
        }

    }

    // 로그인 성공 시 공통 처리 메서드
    private void loginSuccess(HttpServletRequest req, HttpServletResponse resp, String userId) throws IOException {
        HttpSession session = req.getSession(true);
        session.setAttribute("loginUser", userId);
        resp.sendRedirect(req.getContextPath() + "/");
    }

    // 에러 발생 시 공통 처리 메서드 (이게 없어서 에러 났던 거예요!)
    private void showError(HttpServletRequest req, HttpServletResponse resp, String msg) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");
        java.io.PrintWriter out = resp.getWriter();
        out.println("<script>");
        out.println("  alert('" + msg + "');");
        out.println("  location.href='" + req.getContextPath() + "/';");
        out.println("</script>");
        out.close();
    }
}
