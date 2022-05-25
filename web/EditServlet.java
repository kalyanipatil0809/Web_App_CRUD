package in.sts.studentwebapp.web;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import in.sts.studentwebapp.dao.StudentDao;
import in.sts.studentwebapp.model.StudentModel;

/**
 * Servlet implementation class EditServlet
 */

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String student_id = request.getParameter("student_id");
		int Student_id = Integer.parseInt(student_id);
		StudentModel studentModel = StudentDao.getStudentById(Student_id);
		
		request.setAttribute("studentModel", studentModel);
		
		request.getRequestDispatcher("edit.jsp").include(request, response);  
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		String student_id=request.getParameter("student_id").trim();
		String firstName=request.getParameter("firstName");
		String middleName=request.getParameter("middleName");
		String lastName=request.getParameter("lastName");
		String branch=request.getParameter("branch");
		String maths=request.getParameter("maths").trim();
		String english=request.getParameter("english").trim();
		String science=request.getParameter("science").trim();

		StudentModel studentModel = new StudentModel(Integer.parseInt(student_id),firstName.trim(),middleName.trim(),lastName.trim(),branch.trim(), Integer.valueOf(maths) ,Integer.valueOf(english)
				,Integer.valueOf(science));

		boolean status=StudentDao.update(studentModel);
		if(status){
			response.sendRedirect("ViewServlet");
		}else{
			out.println("Sorry! unable to update record");
		}
		out.close();
	}
}













//============================================================================================================================================================

//@WebServlet("/EditServlet")
//public class EditServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	
//	 protected void doGet(HttpServletRequest request, HttpServletResponse
//	 response) throws ServletException, IOException {
//	
//	 request.getRequestDispatcher("edit.jsp").include(request, response); 
//	 
//	 }
//	
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
////		if (request.getParameter("Action").equals("Edit")) {
////			PrintWriter out = response.getWriter();
////			StudentModel studentModel = new StudentModel();
////			StudentDao studentDao = new StudentDao();
////
////			studentModel.setStudent_id(Integer.parseInt(request.getParameter("student_id")));
////			studentModel.setFirstName(request.getParameter("firstName"));
////			studentModel.setMiddleName(request.getParameter("middleName"));
////			studentModel.setLastName(request.getParameter("lastName"));
////			studentModel.setBranch(request.getParameter("Branch"));
////			studentModel.setMaths(Integer.parseInt(request.getParameter("maths")));
////			studentModel.setEnglish(Integer.parseInt(request.getParameter("english")));
////			studentModel.setScience(Integer.parseInt(request.getParameter("science")));
////
//////			RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
//////			dispatcher.include(request, response);
//////			out.print("<br><h2>Doctor Edited Successfully!!</h2>");
////			
////			boolean status=StudentDao.update(studentModel);
////			if(status){
////				response.sendRedirect("ViewServlet");
////			}else{
////				out.println("Sorry! unable to update record");
////			}
////			
//			
//			
//			
//
////		String student_id=request.getParameter("student_id").trim();
////		//		int Student_id=Integer.parseInt(student_id);
////		String firstName=request.getParameter("firstName");
////		String middleName=request.getParameter("middleName");
////		String lastName=request.getParameter("lastName");
////		String branch=request.getParameter("branch");
////		String maths=request.getParameter("maths").trim();
////		String english=request.getParameter("english").trim();
////		String science=request.getParameter("science").trim();
////
////		StudentModel studentModel = new StudentModel(Integer.parseInt(student_id),firstName,  middleName,  lastName,  branch, Integer.valueOf(maths) ,Integer.valueOf(english)
////				,Integer.valueOf(science));
//
////		}
//
////===============================================================================================================================================================================		
//		
//		
//		response.setContentType("text/html");
//		PrintWriter out=response.getWriter();
//
//		String student_id=request.getParameter("student_id").trim();
//		//		int Student_id=Integer.parseInt(student_id);
//		String firstName=request.getParameter("firstName");
//		String middleName=request.getParameter("middleName");
//		String lastName=request.getParameter("lastName");
//		String branch=request.getParameter("branch");
//		String maths=request.getParameter("maths").trim();
//		String english=request.getParameter("english").trim();
//		String science=request.getParameter("science").trim();
//
//		StudentModel studentModel = new StudentModel(Integer.parseInt(student_id),firstName,  middleName,  lastName,  branch, Integer.valueOf(maths) ,Integer.valueOf(english)
//				,Integer.valueOf(science));
//		//		StudentModel studentModel=new StudentModel();
//		//		studentModel.setFirstName(firstName);
//		//		studentModel.setMiddleName(middleName);
//		//		studentModel.setLastName(lastName);
//		//		studentModel.setBranch(branch);
//		//		studentModel.setMaths(Integer.valueOf(maths));
//		//		studentModel.setEnglish(Integer.valueOf(english));
//		//		studentModel.setScience(Integer.valueOf(science));
//		//		studentModel.setStudent_id(Student_id);
//
//		boolean status=StudentDao.update(studentModel);
//		if(status){
//			response.sendRedirect("ViewServlet");
//		}else{
//			out.println("Sorry! unable to update record");
//		}
//		out.close();
//	}
//}