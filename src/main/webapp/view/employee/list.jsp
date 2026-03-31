<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>사원 목록 조회</title>
    <style>
        /* --- 🎨 사수의 모던 UI CSS 디자인 --- */
        body {
            font-family: 'Pretendard', 'Malgun Gothic', sans-serif;
            background-color: #f8f9fa; /* 아주 연한 회색 배경 */
            color: #333;
            margin: 0;
            padding: 40px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .container {
            width: 90%;
            max-width: 1200px;
            background-color: #ffffff;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.05); /* 부드러운 그림자 효과 */
        }

        h2 {
            margin-top: 0;
            color: #2c3e50;
            border-bottom: 2px solid #3498db;
            padding-bottom: 10px;
            display: inline-block;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border-bottom: 1px solid #eee;
            padding: 15px 10px;
            text-align: center;
            font-size: 15px;
        }

        th {
            background-color: #f1f3f5;
            color: #495057;
            font-weight: 600;
            text-transform: uppercase;
            font-size: 14px;
        }

        /* 표 행에 마우스 올렸을 때 하이라이트 효과 */
        tbody tr:hover {
            background-color: #f8f9fa;
            transition: background-color 0.2s ease;
        }

        /* 이름 링크 스타일 */
        .name-link {
            text-decoration: none;
            color: #007bff;
            font-weight: bold;
        }
        .name-link:hover {
            text-decoration: underline;
            color: #0056b3;
        }

        /* 재직 상태 뱃지 스타일 */
        .badge {
            padding: 5px 10px;
            border-radius: 20px;
            font-size: 13px;
            font-weight: bold;
            color: white;
        }
        .badge-working { background-color: #28a745; } /* 초록색: 재직 */
        .badge-retired { background-color: #dc3545; } /* 빨간색: 퇴사 */

        /* 액션 버튼 스타일 */
        .btn {
            padding: 6px 12px;
            text-decoration: none;
            color: white;
            border-radius: 6px;
            font-size: 13px;
            margin: 0 3px;
            transition: opacity 0.2s;
            border: none;
            cursor: pointer;
        }
        .btn:hover { opacity: 0.8; }
        .btn-detail { background-color: #17a2b8; }
        .btn-update { background-color: #ffc107; color: #333; font-weight: bold;}
    </style>
</head>
<body>

<div class="container">
    <h2>🏢 전체 사원 목록</h2>

    <table>
        <thead>
        <tr>
            <th>사번</th>
            <th>이름</th>
            <th>이메일</th>
            <th>전화번호</th>
            <th>부서명</th>
            <th>직급명</th>
            <th>급여</th>
            <th>재직상태</th>
            <th>관리</th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${empty emplist}">
                <tr>
                    <td colspan="9" style="padding: 50px; color: #999;">
                        데이터베이스에 등록된 사원이 없습니다. 텅~ 🌬️
                    </td>
                </tr>
            </c:when>

            <c:otherwise>
                <c:forEach var="emp" items="${emplist}">
                    <tr>
                        <td>${emp.empId}</td>

                        <td>
                            <a href="${pageContext.request.contextPath}/employees/detail?empId=${emp.empId}" class="name-link">
                                    ${emp.empName}
                            </a>
                        </td>

                        <td>${emp.email}</td>
                        <td>${emp.phone}</td>
                        <td>${emp.deptTitle}</td>
                        <td>${emp.jobName}</td>

                        <td>${emp.salary}원</td>

                        <td>
                                <span class="badge ${emp.entYn == 'Y' ? 'badge-retired' : 'badge-working'}">
                                        ${emp.entYn == 'Y' ? '퇴사' : '재직'}
                                </span>
                        </td>

                        <td>
                            <a href="${pageContext.request.contextPath}/employees/detail?empId=${emp.empId}" class="btn btn-detail">상세</a>
                            <a href="${pageContext.request.contextPath}/employees/edit?empId=${emp.empId}" class="btn btn-update">수정</a>
                        </td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
        </tbody>
    </table>
</div>

</body>
</html>