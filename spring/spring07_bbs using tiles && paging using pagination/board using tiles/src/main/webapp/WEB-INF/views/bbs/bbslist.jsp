<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="bit.com.a.dto.BbsDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%-- <%
	List<BbsDto> list = (List<BbsDto>) request.getAttribute("list");
%> --%>
<h3>글목록</h3>

<div class="box_border" style="margin-top: 5px; margin-bottom: 10px">

<table style="margin-left: auto; margin-right: auto; margin-top: 3px; margin-bottom: 3px">
<tr>
	<td></td>
	<td style="padding-left: 5px">
		<select id="_choice" name="choice">
			<option value="" selected="selected">선택</option>
			<option value="title">제목</option>
			<option value="content">내용</option>
			<option value="writer">작성자</option>
		</select>
	</td>
	<td style="padding-left: 5px">
		<input type="text" id="_search" name="searchWord">
	</td>
	<td style="padding-left: 5px">
		<span class="button blue">
			<button type="button" id="btnSearch">검색</button>
		</span>
	</td>
</tr>
</table>
</div>

<table class="list_table" style="width: 85%" id="_lest_table">
	<colgroup>
		<col style="width: 70px">
		<col style="width: auto">
		<col style="width: 80px">
		<col style="width: 100px">
	</colgroup>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>조회수</th>
		<th>작성자</th>
	</tr>
	
	<c:if test="${empty bbslist}">
		<tr>
			<td colspan="4">작성된 글이 없습니다.</td>
		</tr>
	</c:if>
		
	<c:forEach var="list" items="${bbslist}" varStatus="status">
		<c:choose>
			<c:when test="${list.del == 1}">
				<tr>
					<td colspan="4" style="color: red; font: bold;">**** 해당 게시물은 삭제된 게시물 입니다. ****</td>
				</tr>
			</c:when>
			<c:otherwise>
				<tr>
					<td>${list.seq}</td>
					<td><a href="bbsDetail.do?seq=${list.seq}">${list.title}</a></td>
					<td>${list.readcount}</td>
					<td>${list.id}</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</table>

<div class="container" align="right">
    <nav aria-label="Page navigation">
        <ul class="pagination" id="pagination" style="justify-content: center"></ul>
    </nav>
</div>


<script>
$(document).ready(function() {
	$("#_search").val('${param.search}');	
	$("#_choice").val('${param.choice}');	
});


let totalCount = ${totalCount};	// 서버로부터 총 글의 수를 취득
let nowPage = ${param.pageNumber + 1} ; // 서버로부터 현재 페이지를 취득
let pageSize = 10;		// 페이지의 크기 1 ~ 10


let _totalPages = totalCount / 10;
if(totalCount % 10 > 0){
	_totalPages++;
}

$("#pagination").twbsPagination({
	startPage: nowPage,
	totalPages: _totalPages,
	visiblePages: 10,
	initiateStartPageClick: false,
	first:'<span sris-hidden="true">«</span>',
	prev:"이전",
	next:"다음",
	last:'<span sris-hidden="true">»</span>',
	onPageClick:function(event, page){
		location.href = "bbslist.do?search=" + $("#_search").val() + "&choice=" + $("#_choice").val() + "&pageNumber=" + (page - 1);
		//view에서는 pageNumber 1부터 시작! 그래서 -1 해준다. 
	}
});

$("#btnSearch").click(function() {
	location.href = "bbslist.do?search=" + $("#_search").val() + "&choice=" + $("#_choice").val();
});
</script>


