<%@page import="bit.com.a.util.CalendarUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

<c:set var="date" value="${dto.rdate}"/> 
<c:set var = "year" value = "${fn:substring(date, 0, 4)}" />
<c:set var = "month" value = "${fn:substring(date, 4, 6)}" />
<c:set var = "day" value = "${fn:substring(date, 6, 8)}" />
<c:set var = "hour" value = "${fn:substring(date, 8, 10)}" />
<c:set var = "min" value = "${fn:substring(date, 10, 12)}" />
	

<div align="center">

<table class="list_table" style="width: 55%">
<col style="width: 70px">
<col style="width: 40px;">

<tr>
	<th>아이디</th>
	<td style="text-align: left;">${dto.id}</td>
</tr>

<tr>
	<th>제목</th>
	<td style="text-align: left;">${dto.title}</td>
</tr>

<tr>
	<th>일정</th>
	<td style="text-align: left;">${year}년 ${month}월 ${day}일 ${hour}시 ${min}분</td>	
</tr>

<tr>
	<th>내용</th>
	<td style="text-align: left;">
		<textarea rows="20" cols="70" readonly="readonly">${dto.content }
		</textarea>
	</td>
</tr>
</table>
<br>

<span class="blue button">
	<input type="button" value="수정" onclick="location.href='calupdate.do?seq=${dto.seq}'">
</span>

<span class="blue button">
	<input type="button" value="삭제" onclick="location.href='caldel.do?seq=${dto.seq}'">
</span>
 

</div>
</body>
</html>