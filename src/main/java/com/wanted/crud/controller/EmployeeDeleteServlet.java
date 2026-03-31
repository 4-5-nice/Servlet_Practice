package com.wanted.crud.controller;

import com.wanted.crud.dto.EmployeeDetailDTO;
import com.wanted.crud.service.EmployeeDeleteService;
import com.wanted.crud.service.EmployeeDetailService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/employees/delete")
public class EmployeeDeleteServlet extends HttpServlet {
    private EmployeeDeleteService deleteService = new EmployeeDeleteService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        // 세션 가져오는 구문
        HttpSession session = req.getSession(false); // 기존 세션이 없으면 null 반환

        if (session == null) {
            resp.sendRedirect(req.getContextPath() + "/view/common/detailErrorpage.jsp");
            return;
        }

        EmployeeDetailDTO detailDTO = null;

        String empId = req.getParameter("empId");

        if(empId == null || empId.trim().isEmpty()) {
            resp.sendRedirect(req.getContextPath() + "/view/common/detailErrorpage.jsp");
        }

        boolean result;

        try {
            result = deleteService.delete(empId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if(result) {
            resp.sendRedirect(req.getContextPath() + "/employees");
        } else {
            resp.sendRedirect(req.getContextPath() + "/view/common/deleteErrorpage.jsp");
        }

    }
}
