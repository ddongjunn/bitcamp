<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table class="list_table" style="width: 85%" id="_lest_table">
	<colgroup>
		<col style="width: 70px">
		<col style="width: 80px">
	</colgroup>
	<tr>
		<th>제목</th>
		<td>${bbs.title}</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${bbs.id}</td>
	</tr>
	<tr>
		<th>작성일</th>
		<td>${bbs.wdate}</td>
	</tr>
	<tr>
		<th>조회수</th>
		<td>${bbs.readcount}</td>
	</tr>
	<tr>
		<th>정보</th>
		<td>${bbs.ref}-${bbs.step}-${bbs.depth}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea rows="25" cols="103" readonly="readonly">${bbs.content}</textarea></td>
	</tr>
	
</table>
<p style="font-size: 30px; text-align: left; margin-left: 80px; margin-top: 25px">답글</p>
<br>
<form id="frm" method="get">
<input type="hidden" name="seq"   value="${bbs.seq}"/>
		<div>
			<table class="list_table" style="width: 85%" id="_lest_table">
				<col style="width: 70px">
				<col style="width: 80px">
				<tr>
					<th>아이디</th>
					<td><input type="text" name="id" value="${login.id}"size="101" readonly></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" value="" size="101" required="required"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows="25" cols="103" name="content" required="required"></textarea></td>
				</tr>
			</table><br>
				<span class="button blue">
					<button type="button" id="writeBtn">글쓰기</button>
				</span>
		</div>
	</form>

</body>

<script type="text/javascript">
$("#writeBtn").click(function() {
	$("#frm").attr("action", "answerAf.do").submit();
});
</script>
</html>