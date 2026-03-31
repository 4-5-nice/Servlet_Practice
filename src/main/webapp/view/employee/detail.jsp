<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 26. 3. 30.
  Time: 오후 1:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>사원 상세 조회</title>
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
            width: 760px;
            margin: 50px auto;
        }

        .card {
            background-color: #fff;
            border-radius: 16px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.08);
            overflow: hidden;
            margin-bottom: 24px;
        }

        .header {
            background: linear-gradient(135deg, #4e73df, #224abe);
            color: white;
            padding: 28px 30px;
        }

        .header h1 {
            margin: 0;
            font-size: 28px;
        }

        .content {
            padding: 30px;
        }

        .search-form {
            display: flex;
            gap: 12px;
        }

        .search-form input[type="number"] {
            flex: 1;
            padding: 14px;
            font-size: 16px;
            border: 1px solid #dcdfe6;
            border-radius: 10px;
            outline: none;
        }

        .search-form input[type="number"]:focus {
            border-color: #4e73df;
        }

        .search-form button {
            padding: 14px 24px;
            background-color: #4e73df;
            color: white;
            border: none;
            border-radius: 10px;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
        }

        .search-form button:hover {
            background-color: #2e59d9;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 14px 16px;
            border-bottom: 1px solid #e5e7eb;
            text-align: left;
        }

        th {
            width: 180px;
            background-color: #f8f9fc;
        }

        .message {
            padding: 16px;
            border-radius: 10px;
            background-color: #f8f9fc;
            color: #444;
        }

        .section-title {
            margin: 0 0 18px;
            font-size: 22px;
            color: #222;
        }
    </style>
</head>
<body>

<div class="container">
    <!-- 입력 영역 -->
    <div class="card">
        <div class="header">
            <h1>사원 상세 조회</h1>
        </div>
        <div class="content">
            <form action="${pageContext.request.contextPath}/employees/detail" method="get" class="search-form">
                <input type="number" name="empId" placeholder="사원 번호를 입력하세요" required>
                <button type="submit">조회</button>
            </form>
        </div>
    </div>

    <!-- 결과 영역 -->
    <div class="card">
        <div class="content">
            <h2 class="section-title">조회 결과</h2>

            <c:choose>
                <c:when test="${not empty detailDTO}">
                    <table>
                        <tr>
                            <th>사번</th>
                            <td>${detailDTO.empId}</td>
                        </tr>
                        <tr>
                            <th>사원 이름</th>
                            <td>${detailDTO.name}</td>
                        </tr>
                        <tr>
                            <th>사원 이메일</th>
                            <td>${detailDTO.email}</td>
                        </tr>
                        <tr>
                            <th>사원 전화번호</th>
                            <td>${detailDTO.phone}</td>
                        </tr>
                        <tr>
                            <th>부서코드</th>
                            <td>${detailDTO.dept_code}</td>
                        </tr>
                        <tr>
                            <th>부서명</th>
                            <td>${detailDTO.dept_title}</td>
                        </tr>
                        <tr>
                            <th>직급코드</th>
                            <td>${detailDTO.job_code}</td>
                        </tr>
                        <tr>
                            <th>직급명</th>
                            <td>${detailDTO.job_name}</td>
                        </tr>
                        <tr>
                            <th>급여</th>
                            <td>${detailDTO.salary}</td>
                        </tr>
                        <tr>
                            <th>입사일</th>
                            <td>${detailDTO.hire_date}</td>
                        </tr>
                        <tr>
                            <th>퇴직여부</th>
                            <td>${detailDTO.ent_yn}</td>
                        </tr>
                    </table>

                    <form action="${pageContext.request.contextPath}/employees/delete" method="post"
                          onsubmit="return confirm('정말 삭제하시겠습니까?');"
                          style="margin-top: 20px;">
                        <input type="hidden" name="empId" value="${detailDTO.empId}">
                        <button type="submit"
                                style="padding: 12px 20px; background-color: #e74a3b; color: white; border: none; border-radius: 10px; font-size: 15px; font-weight: bold; cursor: pointer;">
                            회원 삭제
                        </button>
                    </form>

                </c:when>

                <c:when test="${not empty message}">
                    <div class="message">${message}</div>
                </c:when>

                <c:otherwise>
                    <div class="message">사원 번호를 입력하고 조회 버튼을 눌러주세요.</div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>

</body>
</html>
