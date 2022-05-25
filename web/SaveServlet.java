package in.sts.studentwebapp.web;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import in.sts.studentwebapp.dao.StudentDao;
import in.sts.studentwebapp.model.StudentModel;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String firstName = request.getParameter("firstName").trim();
		String middleName = request.getParameter("middleName").trim();
		String lastName = request.getParameter("lastName").trim();
		String branch = request.getParameter("branch").trim();
		String maths = request.getParameter("maths");
		String english = request.getParameter("english");
		String science = request.getParameter("science");

		StudentModel studentModel = new StudentModel(firstName, middleName, lastName, branch, Integer.valueOf(maths),
				Integer.valueOf(english), Integer.valueOf(science));

		boolean status = StudentDao.insert(studentModel);
		if (status) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("succsess.jsp");
			requestDispatcher.include(request, response);
		} 
		else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("error.jsp");
			requestDispatcher.include(request, response);
			
		}
	}

}