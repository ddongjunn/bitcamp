
<%@page import="util.CalUtil"%>
<%@page import="dto.CalendarDto"%>
<%@page import="dao.CalendarDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
request.setCharacterEncoding("utf-8");

String title = request.getParameter("title");
String content = request.getParameter("content");
int seq = Integer.parseInt(request.getParameter("seq"));

String year = request.getParameter("year");
String month = request.getParameter("month");
String day = request.getParameter("day");
String hour = request.getParameter("hour");
String min = request.getParameter("min");

String rdate = year + CalUtil.two(month) + CalUtil.two(day) + CalUtil.two(hour) + CalUtil.two(min);


boolean result = CalendarDao.getInstance().updateCalender(title, rdate, content, seq);

if(result){
%>
	<script>
		alert('수정완료');
		location.href = 'calendar.jsp';
	</script>
<%}else{%>
	<script>
		alert('수정실패');
		location.href = 'caldetail.jsp?seq=<%=seq%>'
	</script>
<%}%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>