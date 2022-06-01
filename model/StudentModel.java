package in.sts.studentwebapp.model;

public class StudentModel {
	int student_id;
	String firstName;
	String middleName;
	String lastName;
	String branch;
	int maths;
	int english;
	int science;

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public int getMaths() {
		return maths;
	}

	public void setMaths(int maths) {
		this.maths = maths;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getScience() {
		return science;
	}

	public void setScience(int science) {
		this.science = science;
	}

	public StudentModel() {
		super();
		// TODO Auto-generated constructor stub

	}

	public StudentModel(int student_id, String firstName, String middleName, String lastName, String branch, int maths,
			int english, int science) {
		super();
		this.student_id = student_id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.branch = branch;
		this.maths = maths;
		this.english = english;
		this.science = science;
	}

	public StudentModel(String firstName, String middleName, String lastName, String branch, int maths, int english,
			int science) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.branch = branch;
		this.maths = maths;
		this.english = english;
		this.science = science;
	}

}
