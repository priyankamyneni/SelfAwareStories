package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Answer extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;
	
	@OneToOne
	public Question question;
	 
    public String option1expl;
	
	public String option2expl;
	
	public String option3expl;
	
	public String option4expl;
	
    public String selectedAnswer;
	
	public String correctAnswer;
	
	public String unAnswer;
	
	//public Integer points;
	

}
