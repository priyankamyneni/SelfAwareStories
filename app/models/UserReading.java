package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class UserReading extends BaseEntity {
	@Id
	public Long id;
	
	/*@OneToOne
	public ManageTheme theme;*/
	
	@OneToOne
	public AppUser appUser;
	
	@OneToOne
	public ManageReading manageReading;
	
	
	
}
