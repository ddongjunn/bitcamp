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

name:<p id="name"></p>
age:<h3 id="age"></h3>
birth:<input type="text" id="birth">
<br><br>
<button type="button">클릭</button>

<script type="text/javascript">
$(document).ready(function () {
	$('button').click(function () {
		
		$.ajax({
			url : "data.jsp",
			type : "get",
			datatype : "json",
			
			success : function (data) {
				let json = JSON.parse(data); 
				alert(data);	//문자열로 오기 때문에 json형식으로 변환
				
				$("#name").text(json.name);
				$("#age").html(json.age);
				$("#birth").val(json.birth);
			},
			error : function () {
				
			}
		});
	});
});
</script>
</body>
</html>