package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class QuizAnswer extends BaseEntity{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;
	
    public String option1expl;
	
	public String option2expl;
	
	public String option3expl;
	
	public String selectedAnswer;
	
	public String correctAnswer;
	
	public String unAnswer;

}
