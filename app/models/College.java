package models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.avaje.ebean.Model;

@Entity
public class College extends BaseEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;
	
  
	public String  name;
	
	public String address;

	/*
	@OneToMany(targetEntity=College.class,cascade=CascadeType.ALL)
	public List<Student> studentList=new ArrayList<Student>();*/

	
	
	public static Model.Finder<Long,College> find = new Model.Finder<Long,College>(College.class);
}
