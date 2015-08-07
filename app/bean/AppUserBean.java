package bean;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import models.Alert;
import models.AppUser;
import models.Role;

import org.apache.commons.codec.binary.Base64;

import play.Logger;

public class AppUserBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int match=0;
	public byte[] file1;
	public Long id;
	public String firstName;
	public String lastName;
	public String email;
	//public String dateOfBirth;
	public String userName;
	public String password;
	/*public String collegeName;
	public String collegeAddress;
	public String mobileNumber;
	*/
	public AppUser toEntity() {
		AppUser obj = null;
		if (this.id != null) {
			obj = AppUser.find.byId(id);
			Logger.info(obj.firstName);
		} else {
			obj = new AppUser();
			//obj.save();
		}

		if (this.firstName != null) {
			obj.firstName = this.firstName;

		}
		if (this.lastName != null) {
			obj.lastName = this.lastName;
		}
		if (this.email != null) {
			obj.email = this.email;

		}
		if(this.file1 != null){
			obj.photo = this.file1;
		}
		
		/*if(this.dateOfBirth != null){
		java.sql.Date sqlDate = converStringToDate(this.dateOfBirth);
	obj.dateOfBirth = sqlDate;
		}*/
		
		if (this.userName != null) {
			obj.userName = this.userName;
		}
		if(this.password != null){
		//obj.password = BCrypt.hashpw(this.password, BCrypt.gensalt());
		obj.password=this.password;
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
     AppUser appuserEmail = AppUser.find.where().eq("email",this.email.trim().toLowerCase()).findUnique();
     Pattern pattern = Pattern.compile("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}");
      Matcher matcher = pattern.matcher(this.email.toLowerCase());
      Logger.info(this.email+"**");
      if(matcher.matches()){
          match++;
      }
     if(appuserEmail == null && match!=0  ){
         obj.email = this.email.trim().toLowerCase();
        // obj.role = Role.ADMIN;
         //obj.save();
         
     }
  /*   else{
         if(appuserEmail != null){
             flash().put(
                     "alert",
                     new Alert("alert-danger", "Someone's already using that email")
                     .toString());
             //return ok("Someone's already using that email");
             }
             if(match == 0){
                 flash().put(
                         "alert",
                         new Alert("alert-danger", "Please enter a valid email")
                         .toString());
             }
             //return ok("ok");
         
     }*/
     }catch(Exception e1){
         e1.printStackTrace();
     }
 
		
		
		//obj.save();
		return obj;
	}
/*
	private java.sql.Date converStringToDate(String dateOfBirth ) {
		Logger.info(dateOfBirth +"==");

		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date parsed = null;
		try {
			parsed = format.parse(dateOfBirth);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());

		return sqlDate;

	}*/

	
	
	
	
	

}
