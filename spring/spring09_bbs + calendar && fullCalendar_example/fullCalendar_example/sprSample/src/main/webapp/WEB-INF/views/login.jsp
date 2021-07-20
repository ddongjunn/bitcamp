<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="style.css">
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script> 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="http://lab.alexcican.com/set_cookies/cookie.js" type="text/javascript" ></script>

</head>
<body>



<div class="center" align="center">
<br><h2>login Page</h2><br>
<form action="loginAf.do" method="post">

<table border="1"  rules="rows" cellpadding="5">
<tr>
	<th>아이디</th>
	<td>
		<input type="text" id="id" name="id" size="20"><br>
		<input type="checkbox" id="chk_save_id">save id
	</td>
</tr>
<tr>
	<th>패스워드</th>
	<td>
		<input type="password" name="pwd" size="20">
	</td>
</tr>
<tr>
	<td colspan="2" align="center">
		<input type="submit" class="button" value="로그인">
		<button type="button" class="button" onclick="account()">회원가입</button>
	</td>
</tr>
</table>
</form>
</div>


<script type="text/javascript">
let user_id = $.cookie("user_id");  // 쿠키 키값
if(user_id != null){
	$("#id").val(user_id);
	$("#chk_save_id").prop("checked", true);
}

$("#chk_save_id").click(function () {
//	alert('click');

	if( $("#chk_save_id").is(":checked") ){	// 첵크가 되었을 때		
		if( $("#id").val().trim() == "" ){
			alert('id를 입력해 주십시오');
			$("#chk_save_id").prop("checked", false);
		}else{
			// id를 쿠키에 저장
			$.cookie("user_id", $("#id").val().trim(), { expires:7, path:'/' }); // expires 쿠키저장 시간
		}
	}
	else{
		$.removeCookie("user_id", { path:'/' });
	}	
});

function account() {
	location.href = "regi.do";
}


</script>


</body>
</html>















