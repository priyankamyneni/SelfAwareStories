package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.avaje.ebean.Model;




@Entity
public class Questionarie extends BaseEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;
	
	public String name;
	

	
	
	@OneToMany(cascade=CascadeType.ALL)
	public List<Question> questionList=new ArrayList<Question>();
	

	
	public static Model.Finder<Long,Questionarie> find = new Model.Finder<Long,Questionarie>(Questionarie.class);

}
