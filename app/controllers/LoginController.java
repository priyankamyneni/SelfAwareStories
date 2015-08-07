package controllers;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import models.Alert;
import models.AppUser;
import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import util.Constants;
import bean.LoginBean;

public class LoginController extends Controller{
	
	
	public static final Form<LoginBean> loginForm = Form.form(LoginBean.class);
	
	public Result login(){

		
    	return ok(views.html.login.render());
    	
		
	}
	public Result verify(){
	
		String message = null;
	        Logger.info(Constants.LOGGED_IN_USER_ID+"<--------------cvalue");
	       session().remove(Constants.LOGGED_IN_USER_ID);
	        //session().remove(Constants.LOGGED_IN_USER_ROLE);
	         Form<LoginBean> loginFilledForm = loginForm.bindFromRequest();
	       //  LoginBean loginBean = loginFilledForm.get();
	      
	             try{
	                 LoginBean loginBean = loginFilledForm.get();
	                 Logger.debug(loginBean.email+"-------");
	               List<AppUser> emailList = AppUser.find.where().eq("email",loginBean.email.trim().toLowerCase()).findList();
	                    Logger.debug(emailList.toString()+"-------");
	                   
	                    if(emailList.size()==1){
	                    	Logger.info(emailList.get(0).matchPassword(loginBean.password)+"==");
	                    	
	                         if (emailList.get(0).matchPassword(loginBean.password.trim())) {
	                   // if(emailList !=null && BCrypt.checkpw(loginBean.password,email.password)){	 
	                        	 
	                session(Constants.LOGGED_IN_USER_ID, emailList.get(0).id + "");
	                //session(Constants.LOGGED_IN_USER_ROLE, emailList.get(0).role+ "");
	               
	             /*   if(emailList.get(0).role == Role.ADMIN){
	                    //String url = session(Constants.LOGGED_IN_USER_ID);
	                    //return ok(views.html.profile.coach_dashboard.render(emailList.get(0)));
	                    return ok(" admin logged in");
	                }*/
	                        	 return ok("logged in");
	                //return ok( emailList.get(0).role+" "+"Dashboard");
	                         }
	                    
	                   
	                    return ok("invalid password");
	                 //   return redirect(routes.LoginController.loginAlert(loginBean.login_email, loginBean.login_password));
	             }
	             }catch(NullPointerException e){
	                 Logger.error("ERROR in User Login",e);
	                 message = "Invalid Username/Password.";
	                 return ok(message);
	             }
	             return ok("hii");
	             }
		
		
		
		/*
	        AppUser email = AppUser.find.where().eq("email",loginBean.mailId.trim().toLowerCase()).findUnique();
	        if(email !=null && BCrypt.checkpw(loginBean.password,email.password)){	
	        	 if(email.role == Role.ADMIN){
	                 return ok(" admin logged in");
	                }
	        	 } 
	        return ok("invalid password");
	             
	             }*/
		
	/*public  Result processForgotPassword(){
        final String email = request().body().asFormUrlEncoded().get("email")[0].trim();
        if(email.trim().isEmpty()){
            flash().put("alert", new Alert("alert-info", "Invalidate Email.").toString());
        }else{
            final List<AppUser> appUserList = AppUser.find.where().ieq("email", email).findList();
            if(appUserList.size() == 1){
                final AppUser appUser = appUserList.get(0);
                EmailService.sendForgotPasswordEmail(appUser);
            }
            flash().put("alert", new Alert("alert-info", "Instructions to reset your password has been sent to "+email+".").toString());
        }
        return redirect(routes.Application.index());
    } 
	public static void sendForgotPasswordEmail(final AppUser appUser) {
	    final Random random = new SecureRandom();
	    final String randomString = new BigInteger(130, random).toString(32);
	    boolean result = true;
	     try {
	        final SendGrid sendgrid = new SendGrid(Constants.EMAIL_ID, Constants.EMAIL_PASSWORD);
	        final SendGrid.Email email = new SendGrid.Email();         final StringBuilder builder = new StringBuilder();
	        builder.append("<html><body>");
	        builder.append("<p>Dear " + appUser.name+ ",<br><br>To reset your password, please ");
	        builder.append("<a href=\"http://mednetwork.in/secure-forgot-reset-password/");
	        builder.append(appUser.id);
	        builder.append("/" + randomString + "\">");
	        builder.append("<b>click here.</b>");
	        builder.append("</a><br><br>In case you haven't raised any request for resetting your password, kindly ignore this mail. You can continue using your existing password.<br><br>Best regards,<br>MedNetwork.in</p>");
	        builder.append("</body></html>");
	        email.addTo(appUser.email);
	        email.setFrom("noreply@mednetwork.in");
	        email.setSubject("Reset Password  at MedNetwork");
	        email.setFromName("MedNetwork");
	        email.setHtml(builder.toString());
	        try {
	            final SendGrid.Response response = sendMail(sendgrid, email);
	        } catch (final SendGridException e) {
	            Logger.error("error in send mail",e);
	        }
	        Logger.debug("Mail Sent Successfully!");
	        appUser.forgotPasswordConfirmationKey = randomString;
	        appUser.update();
	        Logger.info(builder.toString());
	    } catch (final Exception e) {
	    Logger.debug("ERROR While Sending Email");
	    Logger.error("Error in Credentials",e);
	    result = false;
	    } */
		
	}


