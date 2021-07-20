<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

<%--
	비동기 통신처리 : 현재 화면에 변경은 하지 않으면서 데이터 통신만 하는 것.
	(화면 변경없이 데이터를 넘겨줄수도 있고, 가져올 수도 있다)
	
	AJAX : Asynchronous JavaScript And Xml(Json 포함)
				
	Axios : Vue, React 에서 사용하는 Ajax
	
	이걸 사용하는 이유?
	속도가 느리다.
			
	web(front)		java(back)
	json			list, String, map
	
	이동
	html 
	<a href=
	<form action=
	
	JS
	location.href
	
	Java
	forward
	sendRedirect

 --%>
 
 <p id="demo"></p>
 <br>
 <button type="button">클릭</button>
 
 <script type="text/javascript">
$(function () {
	$("button").click(function () {
		//alert("click");
		
		//$("#demo").load("data.html");
		//$("#demo").load("data.html #data1");
		//data.html을 불러옴
		
		//$("#demo").load("data.jsp", "t1=abc&t2=123"); 
		//$("#demo").load("data.jsp", {t1:"ABC", t2:"가나다"}); 
		//데이터를 넘겨주고 넘겨받고
		
		$("#demo").load(
			"data.jsp",
			{t1:"ABC", t2:"가나다"},
			function (data, status, xhr) {
				//alert("success"); //문서 전체 출력
				//alert(status); //상태 출력
				alert(xhr); //통신이 되었을때 넘어오는 형태
			}
		);
	
	});
});
 </script>
</body>
</html>