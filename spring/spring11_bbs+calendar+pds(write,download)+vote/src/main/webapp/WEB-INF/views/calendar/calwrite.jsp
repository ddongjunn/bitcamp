<%@page import="bit.com.a.dto.MemberDto"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    

<%
String year = request.getParameter("year");
String month = request.getParameter("month");
String day = request.getParameter("day");

MemberDto login = (MemberDto) session.getAttribute("login");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->
</head>
<body>

<%
Calendar cal = Calendar.getInstance();
int tyear = cal.get(Calendar.YEAR);
int tmonth = cal.get(Calendar.MONTH) + 1;
int tday = cal.get(Calendar.DATE);
int thour = cal.get(Calendar.HOUR_OF_DAY);
int tmin = cal.get(Calendar.MINUTE);

cal.set(Calendar.MONTH, Integer.parseInt(month)-1);
%>


<form id="frm" method="post">

<table class="list_table" style="width: 55%">
	<colgroup>
		<col style="width: 70px">
		<col style="width: 40px">
	</colgroup>
<tr>
	<th>아이디</th>
	<td style="text-align: left">	
		<%=login.getId() %>
	</td>
</tr>
<tr>
	<th>제목</th>
	<td style="text-align: left">
		<input type="text" size="70" name="title">
	</td>
</tr>
<tr>
	<th>일정</th>
	<td style="text-align: left">
		<select name="year" id="_year">
		<%
			for(int i = tyear - 5;i <= tyear + 5; i++){
				%>	
				<option <%=year.equals(i + "")?"selected='selected'":"" %> value="<%=i %>">
					<%=i %>
				</option>
				
				<%
			}		
		%>		
		</select>년	
		
		<select name="month" id="_month">
		<%
			for(int i = 1;i <= 12; i++){
				%>	
				<option <%=month.equals(i + "")?"selected='selected'":"" %> value="<%=i %>">
					<%=i %>
				</option>
				
				<%
			}		
		%>		
		</select>월
		
		<select name="day" id="_day">
		<%
			for(int i = 1;i <= cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++){
				%>	
				<option <%=day.equals(i + "")?"selected='selected'":"" %> value="<%=i %>">
					<%=i %>
				</option>				
				<%
			}		
		%>		
		</select>일
		
		<select name="hour" id="_hour">
		<%
			for(int i = 0;i < 24; i++){
				%>	
				<option <%=(thour + "").equals(i + "")?"selected='selected'":"" %> value="<%=i %>">
					<%=i %>
				</option>				
				<%
			}		
		%>		
		</select>시
		
		<select name="min" id="_min">
		<%
			for(int i = 0;i < 60; i++){
				%>	
				<option <%=(tmin + "").equals(i + "")?"selected='selected'":"" %> value="<%=i %>">
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
	<td style="align-content: left; justify-content: left">
		<textarea rows="20" cols="70" name="content" required="required"></textarea>
	</td>
</tr>
</table>
<br>
<input type="hidden" name="id" value="<%=login.getId()%>">
<input type="hidden" name="rdate" id="_rdate" value="">

<span class="blue button">
	<input type="button" id="writeBtn" value="일정추가">
</span>
</form>

<script type="text/javascript">
$(document).ready(function() {
	 $("select[name='month']").change( setDay );
});

function setDay() {
//	alert('setDay()');
 	let year = $("select[name='year']").val();
	let month = $("select[name='month']").val();

	let lastday = (new Date(year, month, 0)).getDate(); 
//	alert(lastday);

	// 날짜 적용
	let str = '';
	for(i = 1;i <= lastday; i++){
		str += "<option value='" + i + "'>" + i + "</option>";
	}
	
	$("select[name='day']").html(str);
	
	$("select[name='day']").val("<%=day %>"); 
	
}

function two( msg ) {
	let str = "";
	if( msg.length < 2 ){
		str += "0" + msg;
		return str;
	}
	return msg;
}

$("#writeBtn").click(function() {
	
	let _year = $("#_year").val();
	let _month = two($("#_month").val());
	let _day =	two($("#_day").val());
	let _hour = two($("#_hour").val());
	let _min = two($("#_min").val());
	
	let rdate = _year + _month + _day + _hour + _min;
	
	$("#_rdate").val(rdate);
	
	$("#frm").attr("action", "calwriteAf.do").submit();
});

</script>



</body>
</html>








