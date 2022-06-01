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

	private static void commonData(PreparedStatement preparedStatement, StudentModel studentModel) {
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
			preparedStatement = connection.prepareStatement(
					"insert into StudentData(firstName,middleName,lastName,branch,maths,english,science) values (?,?,?,?,?,?,?)");

			commonData(preparedStatement, studentModel);
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
			preparedStatement = connection.prepareStatement(
					"update StudentData set firstName=?,middleName=?,lastName=?,branch=?,maths=?,english=?,science=? where student_id=?");

			preparedStatement.setInt(STUDENT_ID, studentModel.getStudent_id());
			commonData(preparedStatement, studentModel);
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

	public static boolean delete(int student_id) {
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
		if (status == 0) {
			return false;
		} else {
			return true;
		}
	}

	public static StudentModel getStudentById(int student_id) {
		try {
			connection = DBConnection.connect();
			preparedStatement = connection.prepareStatement("select * from StudentData where student_id=?");
			preparedStatement.setInt(1, student_id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				StudentModel studentModel = new StudentModel(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
				
				return studentModel;
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

		return null;
	}

	public static List<StudentModel> getAllStudents() {
		List<StudentModel> studentList = new ArrayList<StudentModel>();
		try {
			connection = DBConnection.connect();
			preparedStatement = connection.prepareStatement("select * from StudentData");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				StudentModel studentModel = new StudentModel(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));

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
