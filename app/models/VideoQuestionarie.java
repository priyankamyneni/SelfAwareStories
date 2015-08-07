package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;







@Entity
public class VideoQuestionarie extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	
	 @OneToOne
	public Video video;
	
     @OneToOne
	public Questionarie questionarie;
     
    

}
