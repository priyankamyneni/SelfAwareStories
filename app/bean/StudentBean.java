package bean;

import java.io.Serializable;

public class StudentBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Long getStudentId() {
		return studentId;
	}


	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Long studentId;
	
	public String firstName;
	
	public String lastName;
	
	
	public String email;	

}
