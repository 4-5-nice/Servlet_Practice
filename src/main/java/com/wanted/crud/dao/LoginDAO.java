package com.wanted.crud.dao;

import com.wanted.crud.global.JDBCTemplate;

import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginDAO {

    public String selectUser(String userId) throws SQLException {
        // DB에서 해당 ID의 비밀번호를 가져오는 코드 (없으면 null 리턴)
        String foundId = null; //db에 저장된 비밀번호
        Connection con = JDBCTemplate.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        //아이디가 일치
        String query = "SELECT EMP_ID FROM EMPLOYEE WHERE EMP_ID = ?";

        pstmt = con.prepareStatement(query);
        pstmt.setString(1, userId);
        rset = pstmt.executeQuery();

        if (rset.next()) {
            foundId = rset.getString("EMP_ID"); //EMP_PWD는 없는 컬럼
        }

        JDBCTemplate.close(rset);
        JDBCTemplate.close(pstmt, con);

        return foundId;
    }
}
