<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

request.do 결과 <hr/>

아이디: ${param.id} <br/>  <!-- memberVO id -->
이름 :  ${param.name} <br/><!-- memberVO name -->
나이 : ${param.age}  <br/>  <!-- memberVO age -->
 
 <hr/>
<!-- 이렇게 하면 안보임용  requestmappingcontorller에 @ModelAttribute("vo") 하면 되긴 됨-->
아이디: ${vo.id} <br/>  <!-- memberVO id -->
이름 :  ${vo.name} <br/><!-- memberVO name -->
나이 : ${vo.age}  <br/>  <!-- memberVO age -->
 
 <hr/>
 
 아이디: ${memberVO.id} <br/>  <!-- memberVO id -->
이름 :  ${memberVO.name} <br/><!-- memberVO name -->
나이 : ${memberVO.age}  <br/>  <!-- memberVO age -->
 
 <hr/>
 
 
</body>
</html>