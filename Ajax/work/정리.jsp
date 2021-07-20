<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
<col width="30px"><col width="100px">
<tr>
	<th>번호</th><th>내용</th>
</tr>
<%
for(int i=0; i<10; i++){
	
%>
<tr>
	<th><%=i %></th><td>내용설명<%=i %></td>
</tr>
<%
}
%>
</table>
</body>
</html>