package models;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
@Entity
public class FeedBack extends BaseEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;
	
	@OneToOne
	public AppUser appUser;
	
	@Column(unique = true)
	public String userName;
	
	@Column(unique = true)
	public String mailId;
	
	@Column(columnDefinition = "TEXT")
	public String message;
	
	@ManyToMany(cascade=CascadeType.ALL)
	public List<AppUser> appUserList= new ArrayList<AppUser>();
	

}
