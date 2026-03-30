package com.wanted.crud.service;

import com.wanted.crud.dao.EmployeeRegistDAO;
import com.wanted.crud.dto.EmployeeRegistDTO;

/* comment.
    사원 등록 관련 비즈니스 문제를 처리하는 Service 클래스
 */

public class EmployeeRegistService {

    // DAO 객체 필드를 선언
    private EmployeeRegistDAO dao = new EmployeeRegistDAO();

    public void registEmployee(EmployeeRegistDTO dto){
        // dao 의 employeeRegist 메서드 dto 넘기는 역할
        dao.employeeRegist(dto);
    }

}
