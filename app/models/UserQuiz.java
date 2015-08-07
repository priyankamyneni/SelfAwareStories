package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class UserQuiz extends BaseEntity{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;
	
	@OneToOne 
	public AppUser appUser;
	
	@OneToOne
	public Quiz quiz;
	

}
