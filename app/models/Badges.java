package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;



@Entity
public class Badges extends BaseEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;

	public String badgeName;
	
	public Integer numberOfPoints;
	
	@Lob
	public byte[] image;
	
	@OneToOne
	public AppUser appuser;
	

}
