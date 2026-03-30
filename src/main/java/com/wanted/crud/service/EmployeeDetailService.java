package com.wanted.crud.service;

import com.wanted.crud.dao.EmployeeDetailDAO;
import com.wanted.crud.dto.EmployeeDetailDTO;
import com.wanted.crud.global.JDBCTemplate;

import java.sql.Connection;
import java.sql.SQLException;

public class EmployeeDetailService { ;

    public EmployeeDetailDTO findMemberByempId(String empId) {

        Connection con = null;
        try{
            con = JDBCTemplate.getConnection();
            EmployeeDetailDAO detailDAO = new EmployeeDetailDAO(con);

            return detailDAO.findById(empId);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
        }


    }
}
