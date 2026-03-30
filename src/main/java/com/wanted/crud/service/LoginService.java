package com.wanted.crud.service;

import com.wanted.crud.dao.LoginDAO;

import java.sql.SQLException;

public class LoginService {

    private LoginDAO inDao = new LoginDAO();

    public String selectUser(String userId) {

        try {
            return inDao.selectUser(userId);
        } catch (SQLException e) {
            // DB 에러가 났는데 그냥 null을 주면 "아이디 없음"으로 오해하니까
            // 런타임 예외를 던져서 시스템에 문제가 생겼음을 알립니다.
            throw new RuntimeException("DB 조회 중 문제가 발생했습니다: " + e.getMessage());
        }
    }
}
