package sample5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDto;

@WebServlet("/sample")
public class SampleServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("SampleServlet doGet()");
		
		resp.setContentType("text/html; charset=utf-8");
			
		PrintWriter pw = resp.getWriter();
		
		pw.println("<html>");
		
		pw.println("<head>");
		pw.println("<title>제목</title>");
		pw.println("</head>");
		
		pw.println("<body>");
		
		pw.println("<h3>Sample Servlet</h3>");

		//짐을 풀자
		MemberDto dto = (MemberDto) req.getAttribute("human");
						//object 이기 때문에 캐스트 변환을 해줘야한다.
		
		pw.println("<h3>이름:" + dto.getName() + "</h3>");
		pw.println("<h3>나이:" + dto.getAge() + "</h3>");
		pw.println("<h3>주소:" + dto.getAddress() + "</h3>");
		pw.println("</body>");
		
		pw.println("</html>");
		pw.close();		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
