package bit.com.a.websocket;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebSocket extends TextWebSocketHandler { //server영역
	
	private Map<String, WebSocketSession> userMap = new ConcurrentHashMap<String, WebSocketSession>();
	
	WebSocket(){ //이클래스가 만들어지는 시점부터 서버가 동작한다.
		System.out.println("EchoHandler 생성됨" + new Date());
	}
	//서버는 통신이 되었으면 클라이언트의 주소를 알고 있다. 
	//서버는 각 클라이언트들에 대한 주소를 다 가지고 있다.
	//클라이언트가 접속되어있어야 보낼 수 있다.
	//클라이언트 -> 서버 접속 -> 

	
	//클라이언트와 접속이 성공했을 때 자동호출
	//클라이언트들이 들어왔을때 마다 동작!
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("연결됨 : " + session.getId() + " " + new Date()); //WebSocketSession!
		userMap.put(session.getId(), session); //id할당은 spring이 할당한다.
		
	}
	
	//클라이언트 접속이 끊기면 호출
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("연결종료 : " + session.getId() + " " + new Date());
		userMap.remove(session.getId());
	}


	//메세지(packet)를 송(send)/수신(receive)하는 함수
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		//프로그램 상에서는 수신을 먼저해야한다.
		//클라이언트에서 데이터를 보내는 시점은 알 수 있다. 날라오는 시점은 알 수 없다. 즉, 데이터를 받을 준비는 무조건 해야된다.
		
		//수신(receive)
		System.out.println("메세지 수신 : " + message.getPayload() + " " + new Date());
		
		//송신(send) - (접속되어 있는 모든 클라이언트에게 전송)
		//특정 클라이언트에게 전송해야하는 경우 여기서 따로 로직을 짜야한다.
		System.out.println("메세지 송신 : " + message.getPayload() + " " + new Date());
		for(WebSocketSession s : userMap.values()) {
			s.sendMessage(message);
		}
	}

	//전송 에러시 예외처리
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		System.out.println("예외발생 : " + session.getId() + " " + new Date());
	}
	
	
	
	
	
	
}
