package in.sts.studentwebapp.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import in.sts.studentwebapp.dao.StudentDao;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {response.setContentType("text/html");

		String s_id = ((ServletRequest) request).getParameter("student_id");
		int Student_id = Integer.parseInt(s_id);
		boolean status = StudentDao.delete(Student_id);
		if (status) {
			response.sendRedirect("ViewServlet");
		} else {
			RequestDispatcher req = request.getRequestDispatcher("error.jsp");
			req.forward(request, response);
		}
	}
}
