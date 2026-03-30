package com.wanted.crud.service;

import com.wanted.crud.dao.EmployeeDeleteDAO;
import com.wanted.crud.global.JDBCTemplate;

import java.sql.Connection;
import java.sql.SQLException;

public class EmployeeDeleteService {


    public boolean delete(String empId) throws SQLException {
        Connection con = null;
        try{
            con = JDBCTemplate.getConnection();
            EmployeeDeleteDAO deleteDAO = new EmployeeDeleteDAO(con);

            return deleteDAO.delete(empId);

        } finally {
            try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }
}
