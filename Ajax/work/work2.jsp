<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	int size = 0;
%>

<%
	size++;
%>

<table border="1">
	<%
	for(int i=1; i < size; i++) {
		%>
		<tr>
			<%
			for(int j = 1; j < size; j++){
				%>
				<td><%=i %>x<%=j %>=<%=i*j %>
				<% 
			}
			%>
		</tr>
		<%
	}
	%>
</table>
</body>
</html>