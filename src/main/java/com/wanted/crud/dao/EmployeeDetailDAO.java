package com.wanted.crud.dao;

import com.wanted.crud.dto.EmployeeDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDetailDAO {

    private final Connection con;
    public EmployeeDetailDAO(Connection con) {
        this.con = con;
    }

    public EmployeeDetailDTO findById(String empId) throws SQLException {
        String sql = "select\n" +
                "    e.emp_id, e.emp_name, e.email, e.phone, e.dept_code, d.dept_title, e.job_code, j.job_name, e.salary, e.hire_date, e.ent_yn\n" +
                "from ((employee e left join department d\n" +
                "        on e.dept_code = d.dept_id) left join job j on e.job_code = j.job_code)\n" +
                "where e.EMP_ID = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, empId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                return mapRow(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (pstmt != null) pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
        return null;
    }

    private EmployeeDetailDTO mapRow(ResultSet rs) throws SQLException {
        return new EmployeeDetailDTO(
                rs.getString("EMP_ID"),
                rs.getString("EMP_NAME"),
                rs.getString("EMAIL"),
                rs.getString("PHONE"),
                rs.getString("DEPT_CODE"),
                rs.getString("DEPT_TITLE"),
                rs.getString("JOB_CODE"),
                rs.getString("JOB_NAME"),
                rs.getInt("SALARY"),
                rs.getString("HIRE_DATE"),
                rs.getString("ENT_YN")
        );
    }
}
