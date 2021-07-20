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

<form id="frm">
<!-- <form action="insertAf.jsp"> -->
아이디&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" id="id" name="id" size="20" placeholder="id입력">
<br>
패스워드&nbsp;
<input type="password" id="pwd" name="pwd" size="20" placeholder="pw입력">
<br><br>
취미<br>
<input type="checkbox" class="hobby" name="hobby" value="잠자기">잠자기
<input type="checkbox" class="hobby" name="hobby" value="노래하기">노래하기
<input type="checkbox" class="hobby" name="hobby" value="게임">게임
<br><br>

연령대<br>
<input type="radio" id="age" name="age" value="10" checked="checked">10대
<input type="radio" id="age" name="age" value="20">20대
<input type="radio" id="age" name="age" value="30">30대
<input type="radio" id="age" name="age" value="40">40대
<input type="radio" id="age" name="age" value="50">50대
<input type="radio" id="age" name="age" value="60">60대
<br><br>

기타하고싶은 말<br>
<textarea id="message" row="50" cols="30" name="message"></textarea>
</form>

<br>
<!-- <input type="submit" value="전송">
<input type="reset" value="취소">
</form> -->
 
<!-- form말고 다른 방법 -->
<button type="button" id="send">전송</button>


<!-- jQuery를 통해서 하는 경우 일단 id 값을 할당 -->
<script type="text/javascript">
$(document).ready(function () {
	/* let id = $('#id').val();
	let pwd = $('#pwd').val();
	
	location.herf = "insertAf.jsp?id=" + id; */
	
	$("#send").click(function () {
		//검사를 할 수 있다. 입력한 칸이 공백인지 아닌지!
		//만약 id가 공백일 경우
		if($("#id").val() == ''){
			alert("아이디를 입력해 주십시오.");
			return;
		}
		
		$("#frm").attr("action","insertAf.jsp");
		$("#frm").submit();
		
	});
});
</script>
</body>
</html>