<%@page import="dto.MemberDto"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
MemberDao dao = MemberDao.getInstance();
MemberDto dto = dao.login(new MemberDto(id, pwd, null,null,0));

if(dto != null && !dto.getId().equals("")){
	// 로그인 정보를 세션에 저장해야한다.
	session.setAttribute("login", dto);
//	session.setMaxInactiveInterval(30 * 60 * 60);
%>
	<script type="text/javascript">
	alert("안녕하세요 <%=dto.getId() %>님");
	location.href = "bbslist.jsp"
	</script>
<%
}else{
%>
	<script type="text/javascript">
	alert("id나 pw를 확인해주세요");
	location.href = "login.jsp"
	</script>

<%
}
%>
</body>
</html>