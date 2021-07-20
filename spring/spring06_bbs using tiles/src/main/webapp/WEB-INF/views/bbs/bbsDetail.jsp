<%@page import="bit.com.a.dto.MemberDto"%>
<%@page import="bit.com.a.dto.BbsDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	BbsDto dto = (BbsDto) request.getAttribute("dto");
	MemberDto login = (MemberDto) session.getAttribute("login");
%>
<table class="list_table" style="width: 85%" id="_lest_table">
	<colgroup>
		<col style="width: 70px">
		<col style="width: 80px;">
	</colgroup>
	<tr>
		<th>제목</th>
		<td><%=dto.getTitle()%></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><%=dto.getId() %></td>
	</tr>
	<tr>
		<th>작성일</th>
		<td><%=dto.getWdate()%></td>
	</tr>
	<tr>
		<th>조회수</th>
		<td><%=dto.getReadcount()%></td>
	</tr>
	<tr>
		<th>정보</th>
		<td><%=dto.getRef()%>-<%=dto.getStep()%>-<%=dto.getDepth()%></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea rows="15" cols="90" readonly="readonly"><%=dto.getContent()%></textarea></td>
	</tr>
	
</table>

<br>
<div>
	<c:if test="${dto.id eq login.id }">		
		<span class="button blue">
			<input type="button" value="수정" onclick="location.href='bbsUpdate.do?seq=<%=dto.getSeq()%>'">
		</span>
		<span class="button blue">
			<input type="button" value="삭제" onclick="location.href='bbsDelete.do?seq<%=dto.getSeq()%>'">
		</span>	
	</c:if>
</div>
