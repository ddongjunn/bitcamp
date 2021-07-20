package sample5;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDto;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HelloServlet doGet()");
		
		String name = req.getParameter("name");
		int age = Integer.parseInt( req.getParameter("age"));
		String address = req.getParameter("address");
		
		
		MemberDto dto = new MemberDto(name, age, address);
		req.setAttribute("human", dto); //짐싸기!
		
		//SampleServlet로 이동
		/*
		 * resp.sendRedirect("sample"); 이건 짐 안가져 간다. 복습할때 해보기 이동만 하며 짐은 안가져 간다.
		 */
		RequestDispatcher rd = req.getRequestDispatcher("sample");
		rd.forward(req, resp); //이동
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
