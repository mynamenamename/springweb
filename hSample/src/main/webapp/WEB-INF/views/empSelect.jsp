<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h2>사원정보 목록보기</h2>

<table border='2'>

<c:forEach items='${result}' var='empVO'>
<tr>
 <td>${empVO.empno}</td> <!-- 우리가 지정한 EmpVO에서 가져오기 때문에 소문자 가능 -->
 <td>${empVO.ename}</td>
</tr>
</c:forEach>

</table>

</body>
</html>