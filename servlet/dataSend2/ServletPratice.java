package sample4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletPratice extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter pw = resp.getWriter();
		
		String fruit = req.getParameter("radio1");
		String hobby[] = req.getParameterValues("check1");
		String introduce = req.getParameter("text1");
		
		pw.println("좋아하는 과일 :"+" "+fruit);
		pw.println("<br>");
		
		pw.print("취미 : ");
		for(int i=0; i < hobby.length; i++) {
			pw.print(hobby[i]);
			pw.print(", ");
		}
		pw.println("<br>");
		
		pw.println("자기소개");
		pw.println(introduce);
		
	}
	
}
