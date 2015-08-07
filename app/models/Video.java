package models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.avaje.ebean.Model;
@MappedSuperclass
@Entity
public class Video extends BaseEntity {

	@Id
    public Long id;
	
	public String name;
	
	@Column(columnDefinition = "TEXT")
	public String description;
	
	public TypeOfVideo typeOfVideo;
	
	public Long vimeoCode;
	
	public static Model.Finder<Long,Video> find = new Model.Finder<Long,Video>(Video.class);

	@Override
	public String toString() {
		return "Video [id=" + id + ", name=" + name + ", description="
				+ description + ", typeOfVideo=" + typeOfVideo + ", vimeoCode="
				+ vimeoCode + "]";
	}
	
	//public Integer numberOfLikes;
	
	
		
	
	
	
	
	

}
