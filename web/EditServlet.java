package in.sts.StudentWebApp.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import in.sts.StudentWebApp.dao.StudentDao;
import in.sts.StudentWebApp.model.StudentModel;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("edit.jsp").include(request, response);  
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		String student_id=request.getParameter("student_id").trim();
		int Student_id=Integer.parseInt(student_id);
		String firstName=request.getParameter("firstName");
		String middleName=request.getParameter("middleName");
		String lastName=request.getParameter("lastName");
		String branch=request.getParameter("branch");
		String maths=request.getParameter("maths").trim();
		String english=request.getParameter("english").trim();
		String science=request.getParameter("science").trim();

		StudentModel studentModel=new StudentModel();
		studentModel.setFirstName(firstName);
		studentModel.setMiddleName(middleName);
		studentModel.setLastName(lastName);
		studentModel.setBranch(branch);
		studentModel.setMaths(Integer.valueOf(maths));
		studentModel.setEnglish(Integer.valueOf(english));
		studentModel.setScience(Integer.valueOf(science));
		studentModel.setStudent_id(Student_id);

		int status=StudentDao.update(studentModel);
		if(status>0){
			response.sendRedirect("ViewServlet");
		}else{
			out.println("Sorry! unable to update record");
		}
		out.close();
	}
}
