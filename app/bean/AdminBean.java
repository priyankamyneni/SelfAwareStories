package bean;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import models.Admin;
import models.AppUser;

import org.apache.commons.codec.binary.Base64;

import play.Logger;

public class AdminBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
public String firstName;
	
	public String lastName;
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	int match=0;
	public Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String email;
	
	
	public String userName;
	
	public String password;
	
	public String salt;
	
	
	
	
	
	public Admin toEntity() {
		Admin obj = null;
		if (this.id != null) {
			obj = Admin.find.byId(id);
	
		} else {
			obj = new Admin();
			//obj.save();
		}

		if (this.userName != null) {
			obj.userName = this.userName;

		}
		if (this.firstName != null) {
			obj.firstName = this.firstName;

		}
		if (this.lastName != null) {
			obj.lastName = this.lastName;

		}
		if (this.password != null) {
			obj.password = this.password;
		}
		if (this.email != null) {
			obj.email = this.email;

		}
		
		
		
		
		
		
		 try {            
         	final Random random = new SecureRandom();
     final byte[] saltArray = new byte[32];
     final String randomSalt = Base64.encodeBase64String(saltArray);
     final String passwordWithSalt = obj.password+randomSalt;
     Logger.info(passwordWithSalt+"__");
     final MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
     final byte[] passBytes = passwordWithSalt.getBytes();
     final String hashedPasswordWithSalt = Base64.encodeBase64String(sha256.digest(passBytes));
     obj.password = hashedPasswordWithSalt;
     obj.salt = randomSalt;
 } catch (Exception e) {
     e.printStackTrace();
 }
 try{
     Admin adminEmail= Admin.find.where().eq("email",this.email.trim().toLowerCase()).findUnique();
     Pattern pattern = Pattern.compile("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}");
      Matcher matcher = pattern.matcher(this.email.toLowerCase());
      Logger.info(this.email+"**");
      if(matcher.matches()){
          match++;
      }
     if(adminEmail == null && match!=0  ){
         obj.email = this.email.trim().toLowerCase();
        // obj.role = Role.ADMIN;
         obj.save();
         
     }
     
 }catch(Exception e1){
     e1.printStackTrace();
 }

	
	
	//obj.save();
	return obj;
}
     
     
     
     

}
