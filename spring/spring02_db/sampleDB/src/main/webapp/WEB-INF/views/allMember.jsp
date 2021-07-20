<%@page import="java.util.List"%>
<%@page import="bit.com.a.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    List<MemberDto> list = (List<MemberDto>) request.getAttribute("memlist");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>allMember</title>
</head>
<body>

<h3>allMember.jsp</h3>
<table>
<%
	for(int i = 0; i < list.size(); i++){
		MemberDto dto = list.get(i);
		%>
		<tr>
			<td><%=i + 1 %></td>
			<td><%=dto.getId() %></td>
			<td><%=dto.getName() %></td>
			<td><%=dto.getEmail() %></td>
		</tr>
		<%
	}
%>
</table>
</body>
</html>