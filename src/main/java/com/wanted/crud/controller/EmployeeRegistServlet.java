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

@WebServlet(urlPatterns = {"/employees/new"})
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
        dto.setEmpNo(req.getParameter("empNo"));
        dto.setEmail(req.getParameter("email"));
        dto.setPhone(req.getParameter("phone"));
        dto.setDeptCode(req.getParameter("deptCode"));
        dto.setJobCode(req.getParameter("jobCode"));

        /* comment.
            salary 변수는 int 방식이다. 하지만 웹에서 보내는 데이터는 String 이다.
            따라서 빈 문자열 또는 공백만 있는 경우를 걸러내기 위해서 아래와 같이 따로
            수정을 했다.
         */

        String salaryParam = req.getParameter("salary");
        if (salaryParam == null || salaryParam.isBlank()) {
            // 만약 salary 가 비어있다면 등록 페이지로 돌려보낸다.
            resp.sendRedirect(req.getContextPath() + "/employees/new");
            return;
        } else {
            dto.setSalary(Integer.parseInt(salaryParam));
        }
        dto.setHireDate(req.getParameter("hireDate"));
        dto.setEntYn(req.getParameter("entYn"));

        service.registEmployee(dto);

        resp.sendRedirect(req.getContextPath() + "/employees");
    }
}