package models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Myjournal extends BaseEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;
	
	public String topicTittle;
	
	@Column(columnDefinition = "TEXT")
	public String description;
	
	


}
