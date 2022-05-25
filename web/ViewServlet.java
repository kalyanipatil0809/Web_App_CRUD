package in.sts.studentwebapp.web;
import java.io.IOException;
import java.util.List;
import in.sts.studentwebapp.dao.StudentDao;
import in.sts.studentwebapp.model.StudentModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		List<StudentModel> studentList = StudentDao.getAllStudents();
		request.setAttribute("studentModel", studentList);
		request.getRequestDispatcher("View.jsp").include(request, response);
	}
}
