package models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class QuizQuestion extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;
	
	@Column(columnDefinition = "TEXT")
	public String description;
	
	@Column(columnDefinition = "TEXT")
	public String question;
	
	public String option1;
	
	public String option2;
	
	public String option3;
	
    public String correctAnswer;
	
	
	
	

}
