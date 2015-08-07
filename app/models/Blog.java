package models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.avaje.ebean.Model;

@Entity
public class Blog extends BaseEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;
	
	public String name;
	
	@Column(columnDefinition = "TEXT")
	public String description;
	
	
	public static Model.Finder<Long,Blog> find = new Model.Finder<Long,Blog>(Blog.class);

}
