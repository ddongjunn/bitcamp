<%@page import="pds.PdsDto"%>
<%@page import="pds.PdsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
int seq = Integer.parseInt(request.getParameter("seq"));

PdsDao dao = PdsDao.getInstance();
dao.readCount(seq);

PdsDto dto = dao.getDto(seq);

if(dto.getContent() == null){
	dto.setContent("");
}

%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>
	<table border="1">
	<col width="100"><col width="300">
		<tr>
			<th>게시자</th><td><%=dto.getId()%></td>
		</tr>
		<tr>
			<th>제목</th><td><%=dto.getTitle()%></td>
		</tr>
		<tr>
			<th>다운로드</th><td><input type="button" name="btnDown" value="파일" onclick="filedownload('<%=dto.getNewFileName()%>', <%=dto.getSeq()%>)"></td>
		</tr>
		<tr>
			<th>조회수</th><td><%=dto.getReadcount()%></td>
		</tr>
		<tr>
			<th>다운수</th><td><%=dto.getDowncount()%></td>
		</tr>
		<tr>
			<th>파일명</th><td><%=dto.getContent() %></td>
		</tr>
		<tr>
			<th>등록일</th><td><%=dto.getRegdate()%></td>
		</tr>
		<tr>
			<th>내용</th><td><textarea cols="60" rows="20" readonly><%=dto.getContent()%></textarea></td>
		</tr>
	</table>	
</div>

<script type="text/javascript">
function filedownload( newFileName, seq ) {
	location.href = 'filedown?newfilename=' + newFileName + '&seq=' + seq; //filedown = servlet
}
</script>

</body>
</html>