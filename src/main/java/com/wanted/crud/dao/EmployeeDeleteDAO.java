package com.wanted.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDeleteDAO {
    private final Connection con;

    public EmployeeDeleteDAO(Connection con) {
        this.con = con;
    }

    public boolean delete(String empId) {
        String sql = "delete from employee where emp_id=?";

        try(PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, empId);
            int  rs = pstmt.executeUpdate();

            if (rs > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
