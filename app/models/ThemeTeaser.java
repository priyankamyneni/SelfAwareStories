package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ThemeTeaser extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;
	
	public String title;
	
	public Long teaserVimeoCode;
	
	@Column(columnDefinition = "TEXT")
	public String description;
	
	

}
