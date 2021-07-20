<%@page import="bit.com.a.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	MemberDto dto = (MemberDto) session.getAttribute("login");
%>
<div class="title">
<h1>글쓰기</h1>
</div><br>
<form id="frm" method="post">
<div align="center">

<table border="1" rules="rows" cellpadding="5" >
<col width="60"><col width="400">
<tr>
	<th>아이디</th>
	<td><input type="text" name="id" value="<%=dto.getId() %>" size="101" readonly></td>
</tr>
<tr>
	<th>제목</th>
	<td><input type="text" name="title" value=""  size="101"></td>
</tr>
<tr>
	<th>내용</th>
	<td><textarea rows="30" cols="103" name="content"></textarea></td>
</tr>

<tr>
	<th colspan="2" class="col text-center" width="30">
	<input type="button" id="writeBtn" value="글쓰기">
	</th>
</tr>
</table><br><br>
</div>
</form>


<script type="text/javascript">
$("#writeBtn").click(function() {
	/* alert('click'); */
	
	//유효성검사를 여기서 진행할 수 있다.
	
	$('#frm').attr("action", "bbsWriteAf.do").submit();
	
});
</script>
</body>
</html>