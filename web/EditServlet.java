package in.sts.StudentDataWebApp.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import in.sts.StudentDataWebApp.dao.StudentDao;
import in.sts.StudentDataWebApp.model.StudentModel;
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>Update Student</h1>");
		String student_id=request.getParameter("student_id");
		int Student_id=Integer.parseInt(student_id);
		
		StudentModel StudentModel=StudentDao.getStudentById(Student_id);
		
		out.print("<form action='EditServlet' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='student_id' value='"+StudentModel.getStudent_id()+"'/></td></tr>");
		out.print("<tr><td>firstName:</td><td><input type='text' name='firstName' value='"+StudentModel.getFirstName()+"'/></td></tr>");
		out.print("<tr><td>middleName:</td><td><input type='text' name='middleName' value='"+StudentModel.getMiddleName()+"'/></td></tr>");
		out.print("<tr><td>lastName:</td><td><input type='text' name='lastName' value='"+StudentModel.getLastName()+"'/></td></tr>");
		out.print("<tr><td>branch:</td><td><input type='text' name='branch' value='"+StudentModel.getBranch()+"'/></td></tr>");
		out.print("<tr><td>maths:</td><td><input type='number' name='maths' value='"+StudentModel.getMaths()+"'/></td></tr>");
		out.print("<tr><td>english:</td><td><input type='number' name='english' value='"+StudentModel.getEnglish()+"'/></td></tr>");
		out.print("<tr><td>science:</td><td><input type='number' name='science' value='"+StudentModel.getScience()+"'/></td></tr>");
	
		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		out.close();
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String student_id=request.getParameter("student_id");
		int Student_id=Integer.parseInt(student_id);
		String firstName=request.getParameter("firstName");
		String middleName=request.getParameter("middleName");
		String lastName=request.getParameter("lastName");
		String branch=request.getParameter("branch");
		String maths=request.getParameter("maths");
		String english=request.getParameter("english");
		String science=request.getParameter("science");
		
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
