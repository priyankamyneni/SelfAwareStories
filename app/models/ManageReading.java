package models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity
public class ManageReading extends BaseEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;
	
	public String name;
	
	public byte[] file;
	
	@Column(columnDefinition = "TEXT")
	public String description;
	
	/*@ManyToMany(cascade=CascadeType.ALL)
	public List<AppUser> appUser = new ArrayList<AppUser>();*/

}
