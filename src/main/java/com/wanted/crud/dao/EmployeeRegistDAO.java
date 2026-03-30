package com.wanted.crud.dao;


import com.wanted.crud.global.JDBCTemplate;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class EmployeeRegistDAO {

    public void employeeRegist(String empId, String empName, String email,
                               String phone, String deptCode, String jobCode,
                               int salary, String hireDate, String entYn) {
        // SQL 쿼리문 (사원번호, 사원명, 이메일, 전화번호, 부서코드, 직급코드, 급여, 입사일, 퇴직여부)
        String sql = "INSERT INTO EMPLOYEE (EMP_ID, EMP_NAME, EMAIL, PHONE, DEPT_CODE, JOB_CODE, SALARY, HIRE_DATE, ENT_YN)" +
        " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // INSERT 는 ResultSet이 필요없음
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JDBCTemplate.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, empId);
            pstmt.setString(2, empName);
            pstmt.setString(3, email);
            pstmt.setString(4, phone);
            pstmt.setString(5, deptCode);
            pstmt.setString(6, jobCode);
            pstmt.setInt(7, salary);
            pstmt.setString(8, hireDate);
            pstmt.setString(9, entYn);

            // 쿼리를 실행하는 코드
            pstmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("선택한 것을 조회할 수 없습니다!!" + e.getMessage());
        } finally {
            JDBCTemplate.close(pstmt, conn);

        }

    }

}
