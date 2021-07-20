<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>helloview</h1>

<%-- <%
String name = (String)request.getAttribute("name");
%>
<%=name %> 가 전송됬다 --%>.
<br>
이름 : ${name}

<br><br>
<form action="world.do">
이름 : <input type="text" name="name"><br>
나이 : <input type="text" name="age"><br>
<input type="submit" value="전송">
</form>

</body>
</html>