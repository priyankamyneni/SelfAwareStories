package models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import play.data.validation.Constraints.Email;

public class Student extends BaseEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;
	
	public String firstName;
	
	public String lastName;
	
	@Column(unique = true)
	@Email
	public String email;
	
	

}
