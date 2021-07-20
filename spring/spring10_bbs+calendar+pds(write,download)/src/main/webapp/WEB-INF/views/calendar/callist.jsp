<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
<table class="list_table" style="width: 85%" id="_list_table">
<colgroup>
	<col style="width: 4%">
	<col style="width: 22%;">
	<col style="width: 22%">
	<col style="width: 37%">
</colgroup>

<tr>
	<th>번호</th><th>제목</th><th>일정</th><th>내용</th>
</tr>

<c:if test="${empty list}">
<tr>
	<td colspan="3">일정이 존재하지 않습니다.</td>
</tr>
</c:if>

<c:forEach items="${list}" var="callist" varStatus="i" >
<tr>
	<td>${i.index + 1}</td> 
	<td><a href="caldetail.do?seq=${callist.seq}">${callist.title}</a></td>
	<c:set var="date" value="${callist.rdate}"/> 
	<c:set var = "year" value = "${fn:substring(date, 0, 4)}" />
	<c:set var = "month" value = "${fn:substring(date, 4, 6)}" />
	<c:set var = "day" value = "${fn:substring(date, 6, 8)}" />
	<c:set var = "hour" value = "${fn:substring(date, 8, 10)}" />
	<c:set var = "min" value = "${fn:substring(date, 10, 12)}" />
	<td>${year}년 ${month}월 ${day}일 ${hour}시 ${min}분</td>
	<td>${callist.content}</td>
</tr>
</c:forEach>
</table>

</body>
</html>