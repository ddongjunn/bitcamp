<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String id = request.getParameter("id");
MemberDao dao = MemberDao.getInstance();
int result = dao.checkId(id);

if(result == 0){
	response.getWriter().write("사용가능한 ID 입니다.");
}else{
	response.getWriter().write("중복된 ID 입니다.");
}

%>

