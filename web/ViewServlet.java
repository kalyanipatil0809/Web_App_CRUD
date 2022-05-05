package in.sts.StudentDataWebApp.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import in.sts.StudentDataWebApp.dao.StudentDao;
import in.sts.StudentDataWebApp.model.StudentModel;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<a href='index.html'>Add New Student</a>");
		out.println("<h1>Students List</h1>");
		List<StudentModel> list = StudentDao.getAllStudents();

		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Student ID</th>"
				+ "<th>First Name</th>"
				+ "<th>Middle Name</th>"
				+ "<th>Last Name</th>"
				+ "<th>Branch</th>"
				+ "<th>Maths</th>"
				+ "<th>English</th>"
				+ "<th>Science</th>"
				+"<th>Edit</th>"
				+"<th>Delete</th>"
				+ "</tr>");
		for(StudentModel studentModel:list){
			out.print("<tr><td>"+studentModel.getStudent_id()+"</td>"
					+ "<td>"+studentModel.getFirstName()+"</td>"
					+ "<td>"+studentModel.getMiddleName()+"</td>"
					+ "<td>"+studentModel.getLastName()+"</td>"
					+ "<td>"+studentModel.getBranch()+"</td>"
					+ "<td>"+studentModel.getMaths()+"</td>"
					+ "<td>"+studentModel.getEnglish()+"</td>"
					+ "<td>"+studentModel.getScience()+"</td>"
					+ "<td><a href='EditServlet?student_id="+studentModel.getStudent_id()+"'>edit</a></td>"
					+ "<td><a href='DeleteServlet?student_id="+studentModel.getStudent_id()+"'>delete</a></td>"
					+ "</tr>");
		}
		out.print("</table>");
		out.close();
	}

}
