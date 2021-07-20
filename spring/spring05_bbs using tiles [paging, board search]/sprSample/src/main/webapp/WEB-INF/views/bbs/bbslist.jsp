<%@page import="bit.com.a.dto.BbsDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
List<BbsDto> list = (List) request.getAttribute("bbsList");

//총 페이지의 수
int len = (int) request.getAttribute("bbsPage");
int bbsPage = len / 10; //1페이지의 수
if((len%10) > 0){
	bbsPage = bbsPage + 1;
}

//현재 페이지 
//처음에 obj로 넘어오기 때문에 null값 검사후 값을 넣어준다.
Object obj = request.getAttribute("pageNumber");
int pageNumber = 0;
if( obj != null ){ 
	pageNumber = (Integer) obj;
}
%>

<%!
// 댓글용
// 깊이(depth)와 image를 추가하는 함수
public String arrow(int depth){
	String rs = "<img src='./image/arrow.png' width='20px' height='20px'>";
	String nbsp = "&nbsp;&nbsp;&nbsp;&nbsp;";
	// 여백 만들기
	String ts = "";
	for(int i=0; i<depth; i++){
		ts += nbsp;
	}
	return depth==0 ? "" : ts+rs;
}
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

<div align="center"> <!-- 페이지수 구하기 -->
<%
for(int i = 0; i < bbsPage; i++){
	if(pageNumber == i){ /* 현재페이지  */
		%>
		<span style="font-size:15pt; color: #0000ff; font-weight: bold;">
			<%=i+1 %>
		</span>&nbsp;	
		<%
	}else{
		%>
			<a href="#none" title="<%=i+1 %>페이지" onclick="goPage(<%=i %>)"
			style="font-size:15pt; color: #000; font-weight: bold; text-decoration: none;">
				[<%=i+1%>]
			</a>&nbsp;	
		<% 
	}
}
%>
</div>

<div align="center">
	<select id="choice">
		<option value="title">제목</option>
		<option value="content">내용</option>
		<option value="writer">작성자</option>
	</select>
	
	<input type="text" id="search" value="">
	<button type="button" onclick="searchBtn()">검색</button>
</div>

</body>

<script type="text/javascript">
function searchBtn() {
	let choice = document.getElementById("choice").value;
	let search = document.getElementById("search").value;
	
	//alert(choice + " " + search);
	
	location.href = "bbslist.do?choice=" + choice + "&search=" + search;
}

function goPage( pageNumber ) {
	let choice = document.getElementById("choice").value;
	let search = document.getElementById("search").value;
	
	location.href = "bbslist.do?choice=" + choice + "&search=" + search + "&pageNumber=" + pageNumber;
}
</script>
</html>