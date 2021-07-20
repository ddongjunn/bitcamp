<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="bit.com.a.dto.BbsDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
	List<BbsDto> list = (List<BbsDto>) request.getAttribute("list");
%>
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
		<input type="text" id="_searchWord" name="searchWord">
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
	<c:choose>
		<c:when test="${fn:length(list) == 0 }">
			<tr>
				<td colspan="4">작성된 글이 없습니다.</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach var="list" items="${list}" varStatus="status">
				<tr>
					<td>${list.seq}</td>
					<td><a href="bbsDetail.do?seq=${list.seq}">${list.title}</a></td>
					<td>${list.readcount}</td>
					<td>${list.id}</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>	
</table>

