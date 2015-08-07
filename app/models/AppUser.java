package models;

import java.security.MessageDigest;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.apache.commons.codec.binary.Base64;

import play.Logger;
import play.data.validation.Constraints.Email;

import com.avaje.ebean.Model;

@Entity
public class AppUser extends BaseEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;
	
	//public Role role;

	public String firstName;
	
	public String lastName;
	
	public byte[] photo;
	
	@Column(unique = true)
	@Email
	public String email;
	
	@Column(unique = true)
	public String userName;
	
	public String password;
	
	public String salt;
	
	//public Date dateOfBirth;
	
//    public String collegeName;
	
//	public String collegeAddress;
	
    //public String mobileNumber;
    
   
   public Boolean matchPassword(final String aPassword) {
        try {
            final String passwordWithSalt = aPassword + this.salt;
            final MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            final byte[] passBytes = passwordWithSalt.getBytes();
            final String hashedPassword = Base64.encodeBase64String(sha256.digest(passBytes));
            Logger.info(hashedPassword+"*****"+this.password);
            if ((hashedPassword.compareTo(this.password))==0) {
                return true;
            } else {
                return false;
            }
        } catch (final Exception e) {
            Logger.debug("error occured while comparing the password", e);
            return false;
        }    } 
    
   @OneToMany(cascade=CascadeType.ALL)
	public List<Report> reportList = new ArrayList<Report>();
	
    

/*    @ManyToOne	
	@JoinColumn(name = "comment_id", referencedColumnName = "id")
	public Comment comment;*/
    
    @ManyToMany(mappedBy = "appUserList")
	public List<Comment> commentList = new ArrayList<Comment>();
    

	@OneToMany(cascade=CascadeType.ALL)
	public List<Myjournal> journalList= new ArrayList<Myjournal>();
	
	@OneToMany(cascade=CascadeType.ALL)
	public List<Blog> blogList=new ArrayList<Blog>();
	
	@ManyToMany(cascade=CascadeType.ALL)
	public List<Video> videoList=new ArrayList<Video>();
	
	public static Model.Finder<Long,AppUser> find = new Model.Finder<Long,AppUser>(AppUser.class);
	

	
	/*@ManyToMany(cascade=CascadeType.ALL)
	public List<Video> videoList = new ArrayList<Video>();*/
	
	

}
