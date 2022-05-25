package in.sts.studentwebapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.sts.studentwebapp.model.StudentModel;
import in.sts.studentwebapp.mysqlconnection.DBConnection;

public class StudentDao {
	static final int FIRST_NAME = 1;
	static final int MIDDLE_NAME = 2;
	static final int LAST_NAME = 3;
	static final int BRANCH = 4;
	static final int MATHS = 5;
	static final int ENGLISH = 6;
	static final int SCIENCE = 7;
	static final int STUDENT_ID = 8;
	static final int DELETE_STUDENT_ID = 1;
	static PreparedStatement preparedStatement = null;
	static Connection connection = null;

	private static void studentData(PreparedStatement preparedStatement, StudentModel studentModel) {
		try {
			preparedStatement.setString(FIRST_NAME, studentModel.getFirstName());
			preparedStatement.setString(MIDDLE_NAME, studentModel.getMiddleName());
			preparedStatement.setString(LAST_NAME, studentModel.getLastName());
			preparedStatement.setString(BRANCH, studentModel.getBranch());
			preparedStatement.setInt(MATHS, studentModel.getMaths());
			preparedStatement.setInt(ENGLISH, studentModel.getEnglish());
			preparedStatement.setInt(SCIENCE, studentModel.getScience());

		} catch (Exception exception) {
			System.out.println("Message:" + exception.getMessage());
		}
	}

	public static boolean insert(StudentModel studentModel) {
		int status = 0;
		try {
			connection = DBConnection.connect();
			preparedStatement = connection.prepareStatement("insert into StudentData(firstName,middleName,lastName,branch,maths,english,science) values (?,?,?,?,?,?,?)");

			studentData(preparedStatement, studentModel);
			status = preparedStatement.executeUpdate();

		} catch (Exception exception) {
			System.out.println("Message:" + exception.getMessage());
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException exception) {
					System.out.println("Message = " + exception.getMessage());
				}
			}
		}
		if (status == 0) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean update(StudentModel studentModel) {
		int status = 0;
		try {
			connection = DBConnection.connect();
			preparedStatement = connection.prepareStatement("update StudentData set firstName=?,middleName=?,lastName=?,branch=?,maths=?,english=?,science=? where student_id=?");

			preparedStatement.setInt(STUDENT_ID, studentModel.getStudent_id());
			studentData(preparedStatement, studentModel);
			status = preparedStatement.executeUpdate();

		} catch (Exception exception) {
			System.out.println("Message:" + exception.getMessage());
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException exception) {
					System.out.println("Message = " + exception.getMessage());
				}
			}
		}
		if (status == 0) {
			return false;
		} else {
			return true;
		}
	}

	public static int delete(int student_id) {
		int status = 0;
		try {
			connection = DBConnection.connect();
			preparedStatement = connection.prepareStatement("delete from StudentData where student_id=?");

			preparedStatement.setInt(DELETE_STUDENT_ID, student_id);
			status = preparedStatement.executeUpdate();

		} catch (Exception exception) {
			System.out.println("Message:" + exception.getMessage());
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException exception) {
					System.out.println("Message = " + exception.getMessage());
				}
			}
		}
		return status;
	}

	public static StudentModel getStudentById(int student_id) {
		StudentModel studentModel = new StudentModel();
		try {
			connection = DBConnection.connect();
			preparedStatement = connection.prepareStatement("select * from StudentData where student_id=?");
			preparedStatement.setInt(1, student_id);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				studentModel.setStudent_id(rs.getInt(1));
				studentModel.setFirstName(rs.getString(2));
				studentModel.setMiddleName(rs.getString(3));
				studentModel.setLastName(rs.getString(4));
				studentModel.setBranch(rs.getString(5));
				studentModel.setMaths(rs.getInt(6));
				studentModel.setEnglish(rs.getInt(7));
				studentModel.setScience(rs.getInt(8));
			}
		} catch (Exception exception) {
			System.out.println("Message:" + exception.getMessage());
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException exception) {
					System.out.println("Message = " + exception.getMessage());
				}
			}
		}
		return studentModel;
	}

	public static List<StudentModel> getAllStudents() {
		List<StudentModel> studentList = new ArrayList<StudentModel>();
		try {
			connection = DBConnection.connect();
			preparedStatement = connection.prepareStatement("select * from StudentData");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				StudentModel studentModel = new StudentModel();
				studentModel.setStudent_id(rs.getInt(1));
				studentModel.setFirstName(rs.getString(2));
				studentModel.setMiddleName(rs.getString(3));
				studentModel.setLastName(rs.getString(4));
				studentModel.setBranch(rs.getString(5));
				studentModel.setMaths(rs.getInt(6));
				studentModel.setEnglish(rs.getInt(7));
				studentModel.setScience(rs.getInt(8));
				studentList.add(studentModel);
			}

		} catch (Exception exception) {
			System.out.println("Message:" + exception.getMessage());
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException exception) {
					System.out.println("Message = " + exception.getMessage());
				}
			}
		}
		return studentList;
	}
}
