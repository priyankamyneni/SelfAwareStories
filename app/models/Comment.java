package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Comment extends BaseEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;
	
	
	
	@ManyToMany(cascade=CascadeType.ALL)	
	@JoinTable(
	        name = "APPUSER_COMMENT",
	        joinColumns = @JoinColumn(name = "COMMENT_ID"),
	        inverseJoinColumns = @JoinColumn(name = "APPUSER_ID")
	)
	public List<AppUser> appUserList = new ArrayList<AppUser>();
	
	@Column(columnDefinition = "TEXT")
	public String comment;

	
	
//	public Integer count;

	

}
