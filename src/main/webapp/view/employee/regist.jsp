<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 26. 3. 30.
  Time: 오후 1:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>💾사원 등록💾</title>
</head>
<body>

    <form action="/employees" method="post">

        <label>🔢사원번호</label>
        <input type="text" name ="empId">

        <label>📛사원명</label>
        <input type="text" name = "empName">

        <label>📧이메일</label>
        <input type="text" name = "email">

        <label>☎️전화번호</label>
        <input type="text" name = "phone">

        <label>⛓️‍💥부서코드</label>
        <input type="text" name = "deptCode">

    </form>
</body>
</html>
