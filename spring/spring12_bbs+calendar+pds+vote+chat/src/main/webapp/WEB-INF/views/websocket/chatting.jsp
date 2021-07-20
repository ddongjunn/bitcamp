<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<table class="list_table" style="width: 85%">
<col width="200px"><col width="500px">

<tr>
	<th>대화명</th>
	<td style="text-align: left;">
		<input type="text" id="name">
		<input type="button" id="enterBtn" value="입장" onclick="connect()">
		<input type="button" id="exitBtn" value="나가기" onclick="disconnect()">
	</td>
</tr>
<tr>
	<th>아이디</th>
	<td style="text-align: left">
		<input type="text" id="id" value="${login.id }">
	</td>
</tr>
<tr>
	<td colspan="2">
		<textarea rows="10" cols="70" id="MessageArea"></textarea>
	</td>
</tr>
<tr>
	<td colspan="2">
		<input type="text" id="message" size="50">
		<input type="button" id="sendBtn" value="전송" onclick="send()" >
	</td>
</tr>

</table>

<script>
var wsocket;

function connect() {
	if(wsocket != undefined && wscoket.readyState != WebSocket.CLOSED){
		alert('이미 입장 하셨습니다.');
		return;
	}
	
	//web socket 생성
//	if($('#name').val() == "aaa"){ //지금 맨 처음 접속은 aaa로 된다 
//		wsocket = new WebSocket("ws://localhost:8090/springSample/echo.do");
//	}
//	else{
		//이주소로 접속을 해야 웹소켓 연결이 된다..
		wsocket = new WebSocket("ws://localhost:8090/springSample/echo.do");
//	}
	
	wsocket.onopen = onOpen;
	wsocket.onmessage = onMessage;
	wsocket.onclose = onClose;
}

function disconnect() {
	wsocket.close();
	location.href = "chating.do";
}


//우리가 네트워크를 사용할때 지정할 3가지 함수
function onOpen(evt) {	//websocket에 연결되었을 때
	appendMessage("서버에 연결되었습니다.");
}

function onMessage(evt) {	//receive(수신)가 되었을 때
	let data = evt.data;
	if(data.substring(0,4) == "msg:"){
		appendMessage(data.substring(4));
	}
}
function onClose(evt) {	//websocket과 연결이 끊겼을 때 
	appendMessage("연결이 끊겼습니다.");
}

//메시지(packet) 송신
function send() {
	let id = $('#name').val();
	let msg = $('#message').val();
	
	wsocket.send("msg:" + id + ":" + msg); //msg:aaa:안녕
	$("#message").val("");
}

//textarea에 문자열을 추가
function appendMessage( msg ) {
	$('#MessageArea').append(msg + "'\n\'");
	
	//스크롤을 위로 이동시킨다.
	const top = $("#MessageArea").prop("scrollHeight");
	$('#MessageArea').scrollTop(top);
}


</script>