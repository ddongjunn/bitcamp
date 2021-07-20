package hello;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;


public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HelloServlet doGet()");

		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");

		/* 회원db에서 id, pwd값 비교 */

		//System.out.println("id=" + id);
		//System.out.println("pwd=" + pwd);

		JSONObject jobj = new JSONObject();
		/*
		 * 1) 문자열로 전송 String str = "World"; //서버에서 응답해주는 데이터.. JSONObject jobj = new
		 * JSONObject(); jobj.put("str", str);
		 * 
		 * resp.setContentType("application/x-json; charset=utf-8");
		 * resp.getWriter().print(jobj); //실제로 전송이 되는 부분..
		 */

		/*
		 * 2) 여러개의 데이터 전송
		 * 
		 * 
		 * HashMap<String, Object> map = new HashMap<String, Object>(); map.put("title",
		 * "이것은 제목 입니다."); map.put("content", "이 글의 내용입니다.");
		 * 
		 * jobj.put("map", map);
		 * 
		 * resp.setContentType("application/x-json; charset=utf-8");
		 * resp.getWriter().print(jobj); //실제로 전송이 되는 부분..
		 */ 
		 
		//dto를 list로 전송
		List<MemberDto> list = new ArrayList<MemberDto>();
		list.add(new MemberDto(1001,"이동준"));
		list.add(new MemberDto(1021,"박남규"));
		list.add(new MemberDto(1261,"호동지"));
		
		jobj.put("list",list);
		
		resp.setContentType("application/x-json; charset=utf-8");
		resp.getWriter().print(jobj); //실제로 전송이 되는 부분..
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HelloServlet doPost()");
	}

}
