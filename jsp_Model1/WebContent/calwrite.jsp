<%@page import="java.util.Calendar"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
MemberDto mem = (MemberDto)session.getAttribute("login");
if(mem == null){
%>  
	<script>
	alert("로그인 해 주십시오");
	location.href = "login.jsp";
	</script>	
<%
}
%> 

<%
String year = request.getParameter("year");
String month = request.getParameter("month");
String day = request.getParameter("day");

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

<%
Calendar cal = Calendar.getInstance(); //지금 현재 기준 
int tyear = cal.get(Calendar.YEAR);
int tmonth = cal.get(Calendar.MONTH) + 1;
int thour = cal.get(Calendar.HOUR_OF_DAY);
int tmin = cal.get(Calendar.MINUTE);

cal.set(Calendar.MONTH, Integer.parseInt(month)-1);
%>

<h2>일정 추가</h2>
<div align="center">

<form action="calwriteAf.jsp" method="post">
<table border="1">
<col width="200"><col width="500">
<tr>
	<th>아이디</th>
	<td>
		<%=mem.getId() %>
		<input type="hidden" name="id" value="<%=mem.getId() %>">
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
					<option <%=year.equals(i + "")?"selected='selected'":"" %> value="<%=i%>"> <!-- 현재 연도가 넘어온 연도가 같을때 selected -->
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
					<option <%=month.equals(i + "")?"selected='selected'":"" %> value="<%=i%>"> 
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
					<option <%=day.equals(i + "")?"selected='selected'":"" %> value="<%=i%>"> 
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
					<option <%=(thour + "").equals(i + "")?"selected='selected'":"" %> value="<%=i%>"> 
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
					<option <%=(tmin + "").equals(i + "")?"selected='selected'":"" %> value="<%=i%>"> 
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
		<textarea rows="20" cols="60" name="content"></textarea>
	</td>
</tr>

<tr>
	<td colspan="2">
		<input type="submit" value="일정추가">
	</td>
</tr>
</table>
</form>
</div>

<script type="text/javascript">

$(document).ready(function() {
	 $("select[name='month']").change( setDay );
});

function setDay() {
	//alert('setDay()');
	let year = $("select[name='year']").val();
	let month =$("select[name='month']").val();
	
	let lastday = new Date(year, month, 0).getDate(); //맨 마지막 날이 나온다.
	
	let str='';
	for(i = 1; i <= lastday; i++){
		str += "<option value='" + i + "'>" + i + "</option>" //문자열로 보내기 위해서 ' '
	}
	
	$("select[name='day']").html(str);
	
	$("select[name='day']").val("<%=day%>");
}
</script>

</body>
</html>