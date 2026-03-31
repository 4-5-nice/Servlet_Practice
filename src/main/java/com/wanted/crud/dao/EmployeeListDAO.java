package com.wanted.crud.dao;

import com.wanted.crud.dto.EmployeeListDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeListDAO {

    public List<EmployeeListDTO> empSelect(Connection con) {
        List<EmployeeListDTO> empList = new ArrayList<>();

        String sql = "SELECT a.EMP_ID, a.EMP_NAME, a.EMAIL, a.PHONE, b.DEPT_TITLE, c.JOB_NAME, a.SALARY, a.ENT_YN "
                + "FROM employee a "
                + "LEFT JOIN department b ON a.DEPT_CODE = b.DEPT_ID "
                + "LEFT JOIN job c ON a.JOB_CODE = c.JOB_CODE";

        try (PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rset = pstmt.executeQuery()) {

            while (rset.next()) {
                EmployeeListDTO employee = new EmployeeListDTO(
                        rset.getString("EMP_ID"),
                        rset.getString("EMP_NAME"),
                        rset.getString("EMAIL"),
                        rset.getString("PHONE"),
                        rset.getString("DEPT_TITLE"),
                        rset.getString("JOB_NAME"),
                        rset.getLong("SALARY"),
                        rset.getString("ENT_YN")
                );
                empList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return empList;
    }
}