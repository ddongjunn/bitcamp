<%@page import="bit.com.a.dto.HumanDto"%>
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

<h1>hello</h1>
<!-- 1 -->
<%
HumanDto h = (HumanDto)request.getAttribute("cls");
%>
이름 : <%=h.getName() %><br>
나이 : <%=h.getAge() %><br>
<br><br>
ELtag<br>
이름 : ${cls.name }<br>
나이 : ${cls.age }<br>
<br><br>

<!-- 2 -->
form<br>
<form action="move.do" method="post">
이름 : <input type="text" name="name" size="10"><br>
나이 : <input type="text" name="age" size="10"><br>
<input type="submit" value="이동">
</form>
<br><br>

<!-- 3 -->
Ajax<br>
아이디 : <input type="text" id="checkid" size="10">
<br><br>
<button type="button" onclick="idcheck()">아이디 체크</button>

<script type="text/javascript">
function idcheck() {
	$.ajax({
		url:"idcheck.do",
		type:"get",
		data:{ id:$("#checkid").val() },
		success:function( data ){
			alert(data);
			
		},
		error:function(){
			alert('error');
		}
	});
}
</script>
<br><br>

<!-- 4 -->
<!-- 
	web(json) -> controller(object)
	controller(list, map) -> web(json)
 -->

이름 : <input type="text" id="name" value="이초희"><br>
전화 : <input type="text" id="phone" value="123-4567"><br>
이메일 : <input type="text" id="email" value="rhdqnx@naver.com"><br>
생년월일 : <input type="text" id="birth" value="1989/01/23"><br>
<button type="button" id="account">회원가입</button>
<br><br>
<div id="demo"></div>


<script type="text/javascript">
$("#account").click(function() {
	// ajax 데이터 만들기 : human
	let human = {
			name:$("#name").val(),
			phone:$("#phone").val(),
			email:$("#email").val(),
			birth:$("#birth").val()
	};
	
	 $.ajax({
	      url:"./account.do",
	      type:"post", 
	      dataType:"json",
	      data:human,
	      success:function( datas ) {
	      //   alert('success');
	      //   alert(JSON.stringify(data));
	      //   alert(json);
	      
	      let str ='';
	      	
	      // alert(datas[0].name);
	      $.each(datas, function(index, data){
	      	str += index + " " + data.name + " " + data.age + "<br>";
	      });
	      $("#demo").append(str);
	      },
	      error:function() {
	         alert('error');
	      }
	   });
});

</script>
<br><br>
<%--
	name : ? 단일
	list : ? 다수
	
	list 안에 name을 넣어서 받고싶은 경우
	컨트롤러에서 name은 name대로 받으면서 list도 받고 싶은 경우
--%>
<button type="button" onclick="func()">map 전송</button>
<script type="text/javascript">
function func() {
	$.ajax({
		url:"read.do",
		type:"get",
		success:function( map ){
		//	alert('success');
		//	alert(map.name);
		alert(JSON.stringify(map.list));
		let json = JSON.stringify(map.list);

	/* 	 $.each(map, function(index, data){
		  	str += index + " " + map.name + " " + map.list + "<br>";
		});
//		$("#demo").append(map.name);
		$("#demo").append(str); */
		},
		error:function() {
	        alert('error');
	    }
	});
}
</script>


</body>
</html>