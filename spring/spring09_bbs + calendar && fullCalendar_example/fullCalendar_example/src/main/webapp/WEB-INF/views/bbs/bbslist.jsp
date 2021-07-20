<%@page import="bit.com.a.dto.BbsDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
List<BbsDto> list = (List) request.getAttribute("bbslist");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>글목록</h1>

<h2>게시판</h2>

<div class="write" align="right" >
<input type="button" class="button" value="자료실" onclick="location.href='pdsList.jsp'"> <!-- 자료실 -->
<input type="button" class="button" value="일정관리" onclick="location.href='calendar.jsp'"> <!-- 일정관리 -->
<input type="button" class="button" value="글쓰기" onclick="location.href='bbsWrite.do'"> <!-- 글쓰기 -->
</div><br>
<table border="1" rules="rows" cellpadding="5" >
<col width="70"><col width="600"><col width="150">
<tr>
	<th>번호</th><th>제목</th><th>작성자</th>
</tr>
<%
if(list == null || list.size() == 0){
%>
	<tr>
		<td colspan="3">작성된 글이 없습니다</td>
	</tr>
<% 
} else{
	for(int i = 0; i < list.size(); i++){ 
		BbsDto bbs = list.get(i);
		%>
		<tr>
			<th><%=i+1 %></th>
			<td>
				<%if(bbs.getDel() == 1){ %>
				관리자에 의해 삭제되었습니다.
				<%} else {%>	
				<a href="bbsDetail.do?seq=<%=bbs.getSeq() %>">
				<%=bbs.getTitle() %>
				<%} %>
				</a>
			</td>
			<td align="center"><%=bbs.getId() %></td>	
		</tr>
	<% } 
}%>
</table>
<br><br>

</body>
</html>