<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%
String add = (String) request.getAttribute("add");

	/* attribute 가 꼭 stirng이 아니여도 되기 때문에 message.dto를 하나 만들어서
	컬럼3개 ( yes, 완료, login.do) 이런식으로도 할 수 있다. */
	
if(add.equals("YES")){
%>
	<script type="text/javascript">
		alert("회원가입완료");
		location.href = "login.do";
	</script>
<%
} else {
%>
	<script type="text/javascript">
		alert("실패");
		location.href = "regi.do";
	</script>

<%
}
%>

</body>
</html>