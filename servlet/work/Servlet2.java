package work;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.MemberDto;

@WebServlet("/second")
public class Servlet2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("second Servlet");
		
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>Second Servlet</title>");
		pw.println("</head>");
		
		pw.println("<body>");
		pw.println("<h3>Second Servlet</h3>");
		
		MemberDto dto = (MemberDto) req.getAttribute("person");
		
		pw.println("<h3>이름 : "+ dto.getName() + "</h3>");
		pw.println("<h3>연령대 : "+ dto.getAge() + "대</h3>");
		pw.println("<h3>성별 : "+ dto.getGender() + "</h3>");
		
		if (dto.getHobby() != null) {
			pw.print("<h3> 취미 : ");
			for (int i = 0; i < dto.getHobby().length; i++) {
				pw.print(dto.getHobby()[i]);
				if (i + 1 != dto.getHobby().length) {
					pw.print(", ");
				}
			}
		}
		pw.println("</h3>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
}
