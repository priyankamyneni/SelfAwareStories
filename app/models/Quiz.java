package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Quiz extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;
	
	/*@OneToOne
	public Video video;*/
	
	//@Column(columnDefinition = "TEXT")
	public String description;
	
	public Scenario scenario;
	
	@OneToMany(targetEntity=Quiz.class,cascade=CascadeType.ALL)
	public List<QuizQuestion> quizQuestionList=new ArrayList<QuizQuestion>();
	
	

}
