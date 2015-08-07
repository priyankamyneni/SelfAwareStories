package controllers;

import java.util.List;

import models.Admin;
import models.AppUser;
import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import util.Constants;
import bean.AdminBean;
import bean.LoginBean;

public class AdminController extends Controller{

public static final Form<AdminBean> adminBean = Form.form(AdminBean.class);
public static final Form<LoginBean> loginForm = Form.form(LoginBean.class);
	
	public Result adminSignUp(){
		
		return ok(views.html.adminsignup.render());
	
	}
	
	public Result adminRegister(){
		
		final Form<AdminBean> filledForm = adminBean.bindFromRequest();
		  AdminBean bean = filledForm.get();
		  session().put("userName",bean.userName);
		  session().put("adminId",bean.id+"");
		  Admin obj=bean.toEntity();
		 // Logger.info(">>>>>>>>>>>>>.firstname "+bean.firstName+">>>>>"+obj.role);
		  obj.save();
	return ok("registered");
	}
	
	public Result adminLogin()
	{
		return ok(views.html.adminlogin.render());
	}
	
	public Result adminSignIn()
	{
		
			
			String message = null;
		        Logger.info(Constants.LOGGED_IN_USER_ID+"<--------------cvalue");
		       session().remove(Constants.LOGGED_IN_USER_ID);
		        //session().remove(Constants.LOGGED_IN_USER_ROLE);
		         Form<LoginBean> loginFilledForm = loginForm.bindFromRequest();
		        LoginBean loginBean = loginFilledForm.get();
		      
		             try{
		                 //LoginBean loginBean = loginFilledForm.get();
		                 Logger.debug(loginBean.email+"-------"+loginBean.password);
		               List<Admin> emailList = Admin.find.where().eq("email",loginBean.email.trim().toLowerCase()).findList();
		                    Logger.debug(emailList.toString()+"-------");
		                   
		                    if(emailList.size()==1){
		                    	Logger.info(emailList.get(0).matchPassword(loginBean.password)+"==");
		                    	
		                         if (emailList.get(0).matchPassword(loginBean.password.trim())) {
		                   // if(emailList !=null && BCrypt.checkpw(loginBean.password,email.password)){	 
		                        	 
		                session(Constants.LOGGED_IN_USER_ID, emailList.get(0).id + "");
		                //session(Constants.LOGGED_IN_USER_ROLE, emailList.get(0).role+ "");
		               
		               /*f(emailList.get(0)=loginBean.){
		                    //String url = session(Constants.LOGGED_IN_USER_ID);
		                    //return ok(views.html.profile.coach_dashboard.render(emailList.get(0)));
		                    return ok(" admin logged in");
		                }*/
		                        	 //return ok("logged in");
		                return redirect(routes.CollegeController.college());		                //return ok( emailList.get(0).role+" "+"Dashboard");
		                         }
		                    
		                   
		                    return ok("login failed");
		                 //   return redirect(routes.LoginController.loginAlert(loginBean.login_email, loginBean.login_password));
		             }
		             }catch(NullPointerException e){
		                 Logger.error("ERROR in User Login",e);
		                 message = "Invalid Username/Password.";
		                 return ok(message);
		             }
		             //return ok("hii");
		             return redirect(routes.CollegeController.college());
		             }
			
			
	
	
}
