/*package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class ManageTheme extends BaseEntity{
	@Id
	public Long id;
	
	@OneToOne
	public ThemeTeaser themeteaser;
	
	
	
	@OneToMany(cascade=CascadeType.ALL)
	public List<SituationVideo> situationVideoList=new ArrayList<SituationVideo>();
		
	@OneToOne
	public Quiz quiz;
	
	@OneToMany(cascade=CascadeType.ALL)
	public List<CopingVideo> copingVideoList=new ArrayList<CopingVideo>();
	
	@OneToOne
	public ManageReading manageReading;
	
	@OneToOne
	public SocialAwareness socialAwareness;
	
	

}
*/