package com.wanted.crud.controller;

import com.wanted.crud.dto.EmployeeDetailDTO;
import com.wanted.crud.service.EmployeeDetailService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/employees/detail")
public class EmployeeDetailServlet extends HttpServlet {
    private EmployeeDetailService detailService = new EmployeeDetailService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        // 세션 가져오는 구문
        HttpSession session = req.getSession(false); // 기존 세션이 없으면 null 반환

        String empId = null;

        if(session != null) {
            empId = req.getParameter("empId");
        }
        EmployeeDetailDTO detailDTO = detailService.findMemberByempId(empId);

        // jsp 에서 사용하는 값 담아주기
        req.setAttribute("detailDTO", detailDTO != null ? detailDTO : "사원 번호 조회 안됨!!!");

        RequestDispatcher rd = req.getRequestDispatcher("/view/employee/detail.jsp");
        rd.forward(req, resp);
    }
}
