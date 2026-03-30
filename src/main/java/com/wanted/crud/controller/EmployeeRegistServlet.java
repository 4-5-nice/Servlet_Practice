package com.wanted.crud.controller;

import com.wanted.crud.dto.EmployeeRegistDTO;
import com.wanted.crud.service.EmployeeRegistService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/* comment.
 *  사원 등록 요청을 처리하는 Servlet
 *  GET /employees/new : 등록 화면 이동
 *  POST /employees : 등록 처리 후 목록으로 redirect
 */

@WebServlet(urlPatterns = {"/employees/new", "/employees"})
public class EmployeeRegistServlet extends HttpServlet {

    private EmployeeRegistService service = new EmployeeRegistService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("loginUser") == null) {
            resp.sendRedirect(req.getContextPath() + "/");
            return;
        }

        req.getRequestDispatcher("/view/employee/regist.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("loginUser") == null) {
            resp.sendRedirect(req.getContextPath() + "/");
            return;
        }

        EmployeeRegistDTO dto = new EmployeeRegistDTO();
        dto.setEmpId(req.getParameter("empId"));
        dto.setEmpName(req.getParameter("empName"));
        dto.setEmail(req.getParameter("email"));
        dto.setPhone(req.getParameter("phone"));
        dto.setDeptCode(req.getParameter("deptCode"));
        dto.setJobCode(req.getParameter("jobCode"));
        dto.setSalary(Integer.parseInt(req.getParameter("salary")));
        dto.setHireDate(req.getParameter("hireDate"));
        dto.setEntYn(req.getParameter("entYn"));

        service.registEmployee(dto);

        resp.sendRedirect(req.getContextPath() + "/employees");
    }
}