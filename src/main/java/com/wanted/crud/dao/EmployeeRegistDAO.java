package com.wanted.crud.dao;


import com.wanted.crud.dto.EmployeeRegistDTO;
import com.wanted.crud.global.JDBCTemplate;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class EmployeeRegistDAO {

    /* comment.
        기존의 EmpId ~ EntYn 9개의 개별 파라미터를 DTO 1개로 변경
        1. 가독성 : DTO 1개가 훨씬 읽기 쉬움
        2. 유지보수 : 필드 추가, 삭제 관점에서 DTO만 수정하면 문제 없음
        3. 일관성 : Service 에서 DAO 로 데이터 전달 시 DTO 객체 그대로 넘기면 됨
        4. 확장성 : 나중에 파라미터가 늘어나도 메서드 시기니처 변경하지 않아도 됨
     */

    public void employeeRegist(EmployeeRegistDTO dto) {
        // SQL 쿼리문 (사원번호, 사원명, 이메일, 전화번호, 부서코드, 직급코드, 급여, 입사일, 퇴직여부)
        String sql = "INSERT INTO EMPLOYEE (EMP_ID, EMP_NAME, EMAIL, PHONE, DEPT_CODE, JOB_CODE, SALARY, HIRE_DATE, ENT_YN)" +
        " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // INSERT 는 ResultSet이 필요없음
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JDBCTemplate.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getEmpId());
            pstmt.setString(2, dto.getEmpName());
            pstmt.setString(3, dto.getEmail());
            pstmt.setString(4, dto.getPhone());
            pstmt.setString(5, dto.getDeptCode());
            pstmt.setString(6, dto.getJobCode());
            pstmt.setInt(7, dto.getSalary());
            pstmt.setString(8, dto.getHireDate());
            pstmt.setString(9, dto.getEntYn());

            // 쿼리를 실행하는 코드
            pstmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("선택한 것을 조회할 수 없습니다!!" + e.getMessage());
        } finally {
            JDBCTemplate.close(pstmt, conn);

        }

    }

}
