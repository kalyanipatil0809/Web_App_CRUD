package in.sts.StudentDataWebApp.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import in.sts.StudentDataWebApp.dao.StudentDao;
import in.sts.StudentDataWebApp.model.StudentModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String firstName = request.getParameter("firstName");
		String middleName = request.getParameter("middleName");
		String lastName = request.getParameter("lastName");
		String branch = request.getParameter("branch");
		String maths = request.getParameter("maths");
		String english = request.getParameter("english");
		String science = request.getParameter("science");

		StudentModel studentModel = new StudentModel();
		studentModel.setFirstName(firstName);
		studentModel.setMiddleName(middleName);
		studentModel.setLastName(lastName);
		studentModel.setBranch(branch);
		studentModel.setMaths(Integer.valueOf(maths));
		studentModel.setEnglish(Integer.valueOf(english));
		studentModel.setScience(Integer.valueOf(science));

		List<StudentModel> list = StudentDao.getAllStudents();
		int count = 0;
		for (StudentModel student : list) {
			if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
				count++;
			}
		}
		if (count == 0) {
			int status = StudentDao.insert(studentModel);
			if (status > 0) {
				out.print("<p>Record saved successfully!</p>");
				response.sendRedirect("ViewServlet");
			} else {
				out.println("Sorry! unable to save record");
			}
		} else {
			out.print("<h1>Record already exists.!</h1>");
			request.getRequestDispatcher("index.html").include(request, response);
		}
		out.close();
	}

}
