<%@page import="util.CalUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="dto.CalendarDto"%>
<%@page import="dao.CalendarDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int seq = Integer.parseInt(request.getParameter("seq"));
CalendarDao dao = CalendarDao.getInstance();
CalendarDto dto = dao.getCal(seq);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
Calendar cal = Calendar.getInstance(); //지금 현재 기준 
int tyear = cal.get(Calendar.YEAR);
int tmonth = cal.get(Calendar.MONTH) + 1;
int thour = cal.get(Calendar.HOUR_OF_DAY);
int tmin = cal.get(Calendar.MINUTE);


String rdate = dto.getRdate(); 
int year = Integer.parseInt(rdate.substring(0,4));
int month = Integer.parseInt(rdate.substring(4,6));
int day = Integer.parseInt(rdate.substring(6,8));
int hour = Integer.parseInt(rdate.substring(8,10));
int min = Integer.parseInt(rdate.substring(10,12));

%>

<h2>일정 수정</h2>
<div>

<form action="calupdateAf.jsp" method="post">
<table border="1">
<col width="200"><col width="500">
<tr>
	<th>아이디</th>
	<td>
		<%=dto.getId() %>
		<input type="hidden" name="seq" value="<%=seq %>">
	</td>
</tr>
<tr>
	<th>제목</th>
	<td>
		<input type="text" size="60" name="title">
	</td>
</tr>
<tr>
	<th>일정</th>
	<td>
		<select name="year">
		<%
			for(int i = tyear - 5; i <= tyear + 5; i++){ //-5년부터 +5년까지
				%>
					<option <%=year == i?"selected='selected'":"" %> value="<%=i%>"> <!-- 현재 연도가 넘어온 연도가 같을때 selected -->
						<%=i %>
					</option>
				<%
			}
		%>
		</select>년
		
		<select name="month">
		<%
			for(int i = 1; i <= 12; i++){ //-5년부터 +5년까지
				%>
					<option <%=month == i?"selected='selected'":"" %> value="<%=i%>"> 
						<%=i %>
					</option>
				<%
			}
		%>
		</select>월
		
		<select name="day">
		<%
			for(int i = 1; i <= cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++){ //-5년부터 +5년까지
				%>
					<option <%=day == i?"selected='selected'":"" %> value="<%=i%>"> 
						<%=i %>
					</option>
				<%
			}
		%>
		</select>일
		
		<select name="hour">
		<%
			for(int i = 1; i < 24; i++){ //-5년부터 +5년까지
				%>
					<option <%=hour == i?"selected='selected'":"" %> value="<%=i%>"> 
						<%=i %>
					</option>
				<%
			}
		%>
		</select>시
		
		<select name="min">
		<%
			for(int i = 0; i < 60; i++){ //-5년부터 +5년까지
				%>
					<option <%=min == i?"selected='selected'":"" %> value="<%=i%>"> 
						<%=i %>
					</option>
				<%
			}
		%>
		</select>분
	</td>
</tr>
<tr>
	<th>내용</th>
	<td>
		<textarea rows="20" cols="60" name="content"><%=dto.getContent() %></textarea>
	</td>
</tr>

<tr>
	<td colspan="2">
		<input type="submit" value="수정하기">
	</td>
</tr>
</table>
</form>
</div>

</body>
</html>