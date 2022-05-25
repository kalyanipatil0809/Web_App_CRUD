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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s_id=((ServletRequest) request).getParameter("student_id");
		int Student_id=Integer.parseInt(s_id);
		StudentDao.delete(Student_id);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("ViewServlet");
		requestDispatcher.include(request, response);
	}
}
