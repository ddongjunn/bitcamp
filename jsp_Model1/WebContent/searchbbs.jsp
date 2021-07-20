<%@page import="dto.BbsDto"%>
<%@page import="java.util.List"%>
<%@page import="dao.BbsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String separator = request.getParameter("separator");
String searchText = request.getParameter("searchText");
BbsDao dao = BbsDao.getInstance();

List<BbsDto> list = dao.searchBbs(separator, searchText);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 id="list">게시판</h2>
<table border="1" >
<col width="70"><col width="600"><col width="150">
<tr>
	<th>번호</th><th>제목</th><th>작성자</th>
</tr>
<%
if(list == null || list.size() == 0){
%>
	<tr>
		<td colspan="3">검색된 글이 없습니다</td>
	</tr>
<% 
} else{
	for(int i = 0; i < list.size(); i++){ 
		BbsDto bbs = list.get(i);
		%>
		<tr>
			<th><%=i+1 %></th>
			<td>
				<a href="bbsdetail.jsp?seq=<%=bbs.getSeq() %>">
				<%=bbs.getTitle() %>
				</a>
			</td>
			<td><%=bbs.getId() %></td>	
		</tr>
	<% } 
}%>

</table>
</body>
</html>