<%@page import="bit.com.a.dto.BbsDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	BbsDto dto = (BbsDto) request.getAttribute("dto");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="bbsUpdateAf.do" method="post">
<table class="list_table" style="width: 85%" id="_lest_table" >
	<colgroup>
		<col style="width: 70px">
		<col style="width: 80px;">
	</colgroup>
<tr>
	<th>아이디</th>
	<td><input type="text" name="id" value="<%=dto.getId()%>" size="101" readonly="readonly"></td>
</tr>
<tr>
	<th>제목</th>
	<td><input type="text" name="title" value="<%=dto.getTitle() %>"  size="101"></td>
</tr>
<tr>
	<th>내용</th>
	<td><textarea rows="30" cols="103" name="content"><%=dto.getContent() %></textarea></td>
</tr>

<tr>
	<th colspan="2" align="center" width="30">
	
	<input type="hidden" name="seq" value="<%=dto.getSeq() %>">
	<input type="submit" class="col text-center" value="수정하기">
	</th>
</tr>
</table><br><br>
</form> 

</body>
</html>