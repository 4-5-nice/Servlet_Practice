package com.wanted.crud.service;

import com.wanted.crud.dao.EmployeeListDAO;
import com.wanted.crud.dto.EmployeeListDTO;
import com.wanted.crud.global.JDBCTemplate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EmployeeListService {

    private final EmployeeListDAO employeeListDAO = new EmployeeListDAO();

    public List<EmployeeListDTO> findAllEmp() {

        Connection con = JDBCTemplate.getConnection();
        List<EmployeeListDTO> resultList = employeeListDAO.empSelect(con);

        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }
}