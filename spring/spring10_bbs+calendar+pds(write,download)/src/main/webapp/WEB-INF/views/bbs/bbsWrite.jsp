<%@page import="bit.com.a.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	MemberDto dto = (MemberDto) session.getAttribute("login");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="frm" method="get">
		<div>
			<table class="list_table" style="width: 85%" id="_lest_table">
				<col width="60">
				<col width="400">
				<tr>
					<th>아이디</th>
					<td><input type="text" name="id" value="<%=dto.getId()%>"size="101" readonly></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" value="" size="101" required="required"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows="30" cols="103" name="content" required="required"></textarea></td>
				</tr>
			</table><br>
				<span class="button blue">
					<button type="button" id="writeBtn">글쓰기</button>
				</span>
		</div>
	</form>
	
	<script type="text/javascript">
	$("#writeBtn").click(function() {
		$("#frm").attr("action", "bbsWriteAf.do").submit();
	});
	</script>
</body>
</html>