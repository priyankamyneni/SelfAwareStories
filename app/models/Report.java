package models;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;



@Entity
public class Report extends BaseEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;
	
	/*@OneToMany(cascade=CascadeType.ALL)
	public List<AppUser> appUserList = new ArrayList<AppUser>();*/
	
	@OneToOne 
	public Answer answer;
	
     

}
