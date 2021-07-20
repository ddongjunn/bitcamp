<%@page import="bit.com.a.dto.MemberDto"%>
<%@page import="bit.com.a.dto.BbsDto"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
/* BbsDao dao = BbsDao.getInstance();
dao.readcount(seq); // 위치선정 중요!! 업데이트를 먼저해서 가져와야한다. */
MemberDto user = (MemberDto) session.getAttribute("login");
BbsDto dto = (BbsDto) request.getAttribute("dto");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script> 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body>
<div class="title">
<h1>상세글보기</h1>
</div>
<div align="center">
<table border="1" rules="rows" cellpadding="5" >
<col width="60"><col width="400">
<tr>
	<th>작성자</th>
	<td><input type="text" size="101" value="<%=dto.getId()%>" readonly="readonly"></td>
</tr>
<tr>
	<th>제목</th>
	<td><%=dto.getTitle() %></td>
</tr>
<tr>
	<th>작성일</th>
	<td><%=dto.getWdate() %></td>
</tr>
<tr>
	<th>조회수</th>
	<td><%=dto.getReadcount() %></td>
</tr>
<tr>
	<th>정보</th>
	<td><%=dto.getRef() %>-<%=dto.getStep() %>-<%=dto.getDepth() %></td>
</tr>
<tr>
	<th>내용</th>
	<td>
	<textarea rows="25" cols="103" readonly="readonly"><%=dto.getContent() %></textarea>
	</td>
</tr>
</table><br>

<button type="button" class="button" onclick="answerBbs(<%=dto.getSeq() %>)">답글</button>
<button type="button" class="button" onclick="location.href='bbslist.jsp'">글목록</button>

<%
if(dto.getId().equals(user.getId())){ // 수정, 삭제는 작성자만 작성해야 하니까 작성자에게만 버튼을 보여주기 위한 조건
%>
<button type="button" class="button" onclick="updateBbs(<%=dto.getSeq() %>)">수정</button>
<button type="button" class="button" onclick="deleteBbs(<%=dto.getSeq() %>)">삭제</button>
<%
}
%>
<input type="button" class="button" value="뒤로가기" onclick="location.href='bbslist.jsp'">



<script type="text/javascript">
function answerBbs( seq ) {
	location.href = "answer.jsp?seq=" + seq;
}
function updateBbs( seq ) {
	location.href = "bbsUpdate.do?seq=" + seq;
}
function deleteBbs( seq ) {
	location.href = "bbsDelete.do?seq=" + seq;
}
</script>

</body>
</html>