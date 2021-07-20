package work;

import java.io.IOException;

import javax.print.attribute.PrintRequestAttributeSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.MemberDto;

@WebServlet("/first")
public class Servlet1 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String gender = req.getParameter("gender");
		String hobby[]= req.getParameterValues("hobby");
		
		System.out.println("name="+name);
		System.out.println("age="+age);
		System.out.println("gender="+gender);
		
		if (hobby != null) {
			for (int i = 0; i < hobby.length; i++) {
				System.out.print("hobby=" + hobby[i] + " ");
			}
			System.out.println();
		}
		
		
		MemberDto dto = new MemberDto(name,age,gender,hobby);
		req.setAttribute("person", dto);
		
		System.out.println("first Servlet finish");
		RequestDispatcher rd = req.getRequestDispatcher("second");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
}
