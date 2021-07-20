<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>regi.jsp</title>

<link rel="stylesheet" href="style.css">
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script> 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>



<div class="center" align="center">
<br><h2>회원가입</h2><br>
<form id="frm" method="post"> <!-- action="regiAf.do" 밑에서 작업 -->
<table border="1"  rules="rows" cellpadding="5">
<tr>
	<th>아이디</th>
	<td>
		<input type="text" id="id" name="id" size="20"><br>
		<p id="idcheck" style="font-size: 8px"></p>
		<input type="button" id="btn" class="button" value="아이디확인">
	</td>
</tr>
<tr>
	<th>패스워드</th>
	<td>
		<input type="text" name="pwd" size="20">
	</td>
</tr>
<tr>
	<th>이름</th>
	<td>
		<input type="text" name="name" size="20">
	</td>
</tr>
<tr>
	<th>이메일</th>
	<td>
		<input type="text" name="email" size="20">
	</td>
</tr>
<tr>
	<td colspan="2" align="center">
		<!-- <input type="submit" class="button" value="회원가입">	 -->
		<input type="button" id="sendBtn" value="회원가입">
		<input type="button" class="button" value="가입취소" onclick="back()">
	</td>
</tr>

</table>
</form>
</div>

<script type="text/javascript">
$(document).ready(function() {
	
	$("#btn").click(function() {
		
		$.ajax({
			// model1 jsp에서 불러오고, model2는 servlet에서 불러온다.
			url:"idCheck.do",  // model2에선 컨트롤러가 된다.
			type:"post",		// jsp일땐 type은 상관없다.
			data:{ "id" : $("#id").val() },
			success:function( data ){
	
				if(data == false){
					$("#idcheck").css("color", "#0000ff");
					$("#idcheck").text("사용할 수 있는 아이디입니다");
				}else{
					$("#idcheck").css("color", "#ff0000");
					$("#idcheck").text("사용할 수 없는 아이디입니다");
					$("#id").val(""); // 내용지우기
				}
			},
			error:function(){
				alert('error');
			}			
		});
	});
	
	$("#sendBtn").click(function() {
		/* alert('click'); */
		
		//유효성검사를 여기서 진행할 수 있다.
		if($("#id").val() == ''){
			alert('아이디를 입력해주세요');
			return;
		}
		
		$('#frm').attr("action", "regiAf.do").submit();
		
	});
	
});
function back() {
	location.href="login.do"
}

</script>

</body>
</html>







