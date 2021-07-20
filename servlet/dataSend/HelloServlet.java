package sample3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		
		String food[] = req.getParameterValues("food");
		
		PrintWriter pw = resp.getWriter();
		
		pw.println("<html>");
		
		pw.println("<head>");
		pw.println("<title>제목</title>");
		pw.println("</head>");
		
		pw.println("<body>");
		
		pw.println("<h3>Hello Servlet</h3>");
		pw.println("<h3>이름:"+ name + "</h3>");
		pw.println("<p>나이:"+ age + "</p>");
		
		if(food != null) {
			for(int i=0; i < food.length; i++) {
				pw.println("<p>좋아하는 음식:"+ food[i] + "</p>");
			}
		}
		
		pw.println("<a href='sample'>"+"SampleServlet이동"+"<a>"); //서블릿에서 다시 html로 
			
		pw.println("</body>");
		
		pw.println("</html>");
		pw.close();
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
