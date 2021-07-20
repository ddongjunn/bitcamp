<%@page import="dao.CalendarDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
int seq = Integer.parseInt(request.getParameter("seq"));

boolean result = CalendarDao.getInstance().deleteCalendar(seq);
%>
<%if(result){ %>
	<script>
		alert('삭제완료');
		location.href = 'calendar.jsp';
	</script>
<%}else{ %>
	<script>
		alert('삭제실패');
		location.href = 'caldetail.jsp?seq=<%=seq%>';
	</script>
<%} %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>