package com.wanted.crud.controller;

import com.wanted.crud.dto.EmployeeListDTO;
import com.wanted.crud.service.EmployeeListService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/employees")
public class EmployeeListServlet extends HttpServlet {

    private final EmployeeListService employeeListService = new EmployeeListService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<EmployeeListDTO> emplist = employeeListService.findAllEmp();
        req.setAttribute("emplist", emplist);

        RequestDispatcher rd = req.getRequestDispatcher("/view/employee/list.jsp");
        rd.forward(req, resp);
    }
}