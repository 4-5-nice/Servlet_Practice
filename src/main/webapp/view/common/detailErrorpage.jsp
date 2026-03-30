<%--
  Created by IntelliJ IDEA.
  User: jw4690
  Date: 2026-03-30
  Time: 오후 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>에러 페이지</title>
  <style>
    * {
      box-sizing: border-box;
    }

    body {
      margin: 0;
      font-family: "Malgun Gothic", sans-serif;
      background-color: #f4f6f9;
      color: #333;
    }

    .container {
      width: 700px;
      margin: 100px auto;
    }

    .card {
      background-color: #fff;
      border-radius: 16px;
      box-shadow: 0 8px 20px rgba(0, 0, 0, 0.08);
      overflow: hidden;
    }

    .header {
      background: linear-gradient(135deg, #e74a3b, #c0392b);
      color: white;
      padding: 28px 30px;
    }

    .header h1 {
      margin: 0;
      font-size: 28px;
    }

    .content {
      padding: 30px;
      text-align: center;
    }

    .message {
      font-size: 18px;
      margin-bottom: 24px;
    }

    .btn {
      display: inline-block;
      padding: 12px 22px;
      background-color: #4e73df;
      color: white;
      text-decoration: none;
      border-radius: 10px;
      font-weight: bold;
    }

    .btn:hover {
      background-color: #2e59d9;
    }
  </style>
</head>
<body>
<div class="container">
  <div class="card">
    <div class="header">
      <h1>오류 발생</h1>
    </div>
    <div class="content">
      <p class="message">
        존재하지 않는 사번입니다.
      </p>

      <a href="${pageContext.request.contextPath}/employees/detail" class="btn">
        다시 조회하기
      </a>
    </div>
  </div>
</div>
</body>
</html>
