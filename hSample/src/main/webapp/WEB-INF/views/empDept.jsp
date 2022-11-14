<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<!--태그 형식 c ! 설정하기 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empDept.jsp</title>
</head>
<body>

<h2>사원정보 목록보기</h2>

<table border='2'>

<c:forEach items='${result}' var='hashmap'>
<tr>
 <td>${hashmap.ENAME}</td> <!-- 대문자로 해야 나옴 ,,,, 오라클에서 바로 받는거니까 -->
 <td>${hashmap.EMPNO}</td>
 <td>${hashmap.DNAME}</td>
</tr>
</c:forEach>

</table>

</body>
</html>