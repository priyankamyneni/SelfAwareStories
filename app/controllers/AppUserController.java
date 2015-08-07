package controllers;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.apache.commons.codec.binary.Base64;

import models.Alert;
import models.AppUser;
import models.Role;
import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import util.Constants;
import bean.AppUserBean;

public class AppUserController extends Controller {

	public static final Form<AppUserBean> appUserBean = Form.form(AppUserBean.class);
	
	
	public Result signUp(){
		
		return ok(views.html.signUp.render());
	
	}
	
	public Result register(){
		
		final Form<AppUserBean> filledForm = appUserBean.bindFromRequest();
		  AppUserBean bean = filledForm.get();
		  session().put("userName",bean.userName);
		  AppUser obj=bean.toEntity();
		 // Logger.info(">>>>>>>>>>>>>.firstname "+bean.firstName+">>>>>"+obj.role);
		  obj.save();

		/*final Form<AppUserBean> filledForm = appUserBean.bindFromRequest();
		
      AppUserBean bean = filledForm.get();
		Logger.info(bean.dateOfBirth+"__");
		
		AppUser obj = bean.toEntity();

		obj.save();

		return ok("registered");
	
	}*/
	
	
	
	/*
	
	int match=0;
    AppUser appUser = new AppUser();
    
    appUser =bean.toEntity();
    //Logger.info(appUser.password+"<=============passs");
            try {            
            	final Random random = new SecureRandom();
        final byte[] saltArray = new byte[32];
        final String randomSalt = Base64.encodeBase64String(saltArray);
        final String passwordWithSalt = appUser.password+randomSalt;
        Logger.info(passwordWithSalt+"__");
        final MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
        final byte[] passBytes = passwordWithSalt.getBytes();
        final String hashedPasswordWithSalt = Base64.encodeBase64String(sha256.digest(passBytes));
        appUser.password = hashedPasswordWithSalt;
        appUser.salt = randomSalt;
    } catch (Exception e) {
        e.printStackTrace();
    }
    try{
        AppUser appuserEmail = AppUser.find.where().eq("email",bean.email.trim().toLowerCase()).findUnique();
        Pattern pattern = Pattern.compile("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}");
         Matcher matcher = pattern.matcher(bean.email.toLowerCase());
         Logger.info(bean.email+"**");
         if(matcher.matches()){
             match++;
         }
        if(appuserEmail == null && match!=0  ){
            appUser.email = bean.email.trim().toLowerCase();
            appUser.role = Role.ADMIN;
            appUser.save();
            
        }
        else{
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
            
        }
        }catch(Exception e1){
            e1.printStackTrace();
        }*/
    
    
    return redirect(routes.AppUserController.welcome(obj.userName));
    
}
	public Result welcome(String userName)
	{
		
		session("username",userName);
		Logger.info(session("constatnt")+"<-----------------------");
		return ok(views.html.welcome.render(userName));
	}

	
	
	
	

}
