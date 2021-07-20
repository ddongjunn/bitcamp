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

<p id="demo"></p>
<br>
<button type="button">클릭</button>

<script type="text/javascript">
$(document).ready(function () {
	$("button").click(function () {
		$.ajax({
			url:"data.json",
			type:"get",
			datatype:"json",
			success:function( data ){
				//alert('success');
				//alert(data);
				
				//let str = JSON.stringify(data); //반대 : parse()
				//alert(str);
			
				//alert(data[0].name); : 홍길동
				
				//데이터 올리는 법
				
				//(JS문법)
				/*for(let i=0; i < data.length; i++){
					$("#demo").append(data[i].name + " ");
					$("#demo").append(data[i].age + " ");
					$("#demo").append(data[i].address + " ");
					$("#demo").append(data[i].phone + "<br>");
				}*/
				
				//(jQuery 문법)
				$.each(data, function (index, item) { // index = i , item = data[i]
					$("#demo").append(index + " ");
					$("#demo").append(item.name + " ");
					$("#demo").append(item.age + " ");
					$("#demo").append(item.address + " ");
					$("#demo").append(item.phone + "<br>");
				});
				
			},
			error:function(){
				alert('error');
			}
			//url:경로 type:get,post
			
		});
	});
});
</script>
</body>
</html>