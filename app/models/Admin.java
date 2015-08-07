package models;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.apache.commons.codec.binary.Base64;

import play.Logger;
import play.data.validation.Constraints.Email;

import com.avaje.ebean.Model;

@Entity
public class Admin extends BaseEntity{
	@Id
	public Long id;
public String firstName;
	
	public String lastName;

	@Column(unique = true)
	@Email
	public String email;
	
	@Column(unique = true)
	public String userName;
	
public String password;
	public String salt;
	
	

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
	   public List<College> collegeList=new ArrayList<College>();
	   
	   
	public static Model.Finder<Long,Admin> find = new Model.Finder<Long,Admin>(Admin.class);

}
