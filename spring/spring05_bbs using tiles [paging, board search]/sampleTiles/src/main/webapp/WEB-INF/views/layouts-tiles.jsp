<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 기본 layout -->
<table width="100%" height="100%" bordercolor="grady">

<!-- header -->
<tr align="center" style="background-color: black; color:white;">
	<td height="10%" colspan="3">
		<tiles:insertAttribute name="header" />
	</td>
</tr>
<!-- content -->
<tr>
	<td width="20%" align="left" valign="top" style="background-color: rgb(204,204,204)">
		<tiles:insertAttribute name="menu"/>
	</td>
	<td>
		<tiles:insertAttribute name="content"/>
	</td>
	<td width="15%" align="center">
		<tiles:insertAttribute name="empty"/>
	</td>
	
</tr>

<!-- footer -->
<tr align="center" style="background-color: black; color:white;">
	<td height="10%" colspan="3">
		<tiles:insertAttribute name="footer" />
	</td>
</tr>
</table>

</body>
</html>