<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//java 영역
//db와 접근(dao)이 가능

String id = request.getParameter("id");
String pw = request.getParameter("pwd");

System.out.println("id:"+id);
System.out.println("pwd:"+pw);
%>
</body>
</html>