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
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");
String hobby[] = request.getParameterValues("hobby");
String age = request.getParameter("age");
String message = request.getParameter("message");

out.println("id :" + id + "<br>");
out.println("pwd :" + pwd + "<br>");
if(hobby != null){
	for(int i=0; i < hobby.length; i++){
		out.println("hobby : " + hobby[i] + "<br>");
	}
}
out.println("age : " + age + "<br>");
out.println("message : " + message + "<br>");
%>
</body>
</html>