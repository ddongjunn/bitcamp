<%@page import="dto.CalendarDto"%>
<%@page import="dao.CalendarDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
int seq = Integer.parseInt(request.getParameter("seq"));

System.out.println(seq);

CalendarDao dao = CalendarDao.getInstance();
CalendarDto dto = dao.getCal(seq);

String rdate = dto.getRdate(); 
String year = rdate.substring(0,4);
String month = rdate.substring(4,6);
String day = rdate.substring(6,8);
String hour = rdate.substring(8,10);
String min = rdate.substring(10,12);

%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>일정보기</h2>
<table border="1">
<col width="200"><col width="500">
<tr>
	<th>아이디</th>
	<td>
		<%=dto.getId() %>
	</td>
</tr>
<tr>
	<th>제목</th>
	<td>
		<%=dto.getTitle() %>
	</td>
</tr>
<tr>
	<th>일정</th>
	<td>
	<%=year %>년 <%=month %>월 <%=day %>일 <%=hour %>시 <%=min %>분

	</td>
</tr>

<tr>
	<th>내용</th>
	<td>
		<textarea rows="20" cols="60" name="content" readonly><%=dto.getContent() %></textarea>
	</td>
</tr>

<tr>
	<td colspan="2">
		<input type="button" value="수정하기" onclick="updateCal(<%=seq%>)">
		<input type="button" value="삭제하기" onclick="deleteCal(<%=seq%>)">
	</td>
</tr>
</table>


<script type="text/javascript">
function updateCal( seq ) {
	location.href = "calupdate.jsp?seq=" + seq;
}
function deleteCal( seq ) {
	location.href = "caldelete.jsp?seq=" + seq;
}
</script>
</body>
</html>