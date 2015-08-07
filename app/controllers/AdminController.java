package controllers;

import java.util.List;

import models.Admin;
import models.College;
import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import util.Constants;
import bean.AdminBean;
import bean.CollegeBean;
import bean.LoginBean;

public class AdminController extends Controller{

public static final Form<AdminBean> adminBean = Form.form(AdminBean.class);
public static final Form<LoginBean> loginForm = Form.form(LoginBean.class);
public static final Form<CollegeBean> collegeBean = Form.form(CollegeBean.class);
	
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
		       
		     //  session().remove(Constants.LOGGED_IN_USER_ID);
	
		         Form<LoginBean> loginFilledForm = loginForm.bindFromRequest();
		        LoginBean loginBean = loginFilledForm.get();
		        session().put("userName",loginBean.userName);
		      
		             try{
		                 
		                 Logger.debug(loginBean.userName+"-------"+loginBean.password);
		               List<Admin> userList = Admin.find.where().eq("userName",loginBean.userName.trim().toLowerCase()).findList();
		                    Logger.debug(userList.toString()+"-------");
		                   
		                    if(userList.size()==1){
		                    	Logger.info(userList.get(0).matchPassword(loginBean.password)+"==");
		                    	
		                         if (userList.get(0).matchPassword(loginBean.password.trim())) {
		                   // if(emailList !=null && BCrypt.checkpw(loginBean.password,email.password)){	 
		                        	 
		                session(Constants.LOGGED_IN_USER_ID, userList.get(0).id + "");
		                Logger.info(Constants.LOGGED_IN_USER_ID+"<--------------cvalue");
		                        	 //return ok("logged in");
		                return redirect(routes.AdminController.college());		                
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
		            // return redirect(routes.AdminController.college());
		             return ok(views.html.adminpannel.render());
		             }
			public static Admin getLoggedInUser(){
				
				Long id = null;
		        final String idStr = session(Constants.LOGGED_IN_USER_ID);
		        Logger.debug(idStr);
		        if (idStr != null) {
		            id = Long.parseLong(idStr);           
		            return Admin.find.byId(id);
		        }
		        /* final Long id = Long.parseLong(idStr); */
		        // return AppUser.find.byId(id);  
		        //return null;
				return null;
				
			}
	public Result college(){
		final Admin admin=AdminController.getLoggedInUser();
		Logger.debug(admin+"");
		final Form<CollegeBean> filledForm = collegeBean.bindFromRequest();
		  CollegeBean bean = filledForm.get();
		
		
		Admin admin1=Admin.find.where().eq("id",bean.adminId).findUnique();
	//	Logger.info(session().get("adminId")+"-------");
		//return ok(views.html.college.render(admin));
		Logger.info(admin+":::::");
			return ok(views.html.college.render(admin));
		
		}
	public Result saveCollege()
	{
		final Form<CollegeBean> filledForm = collegeBean.bindFromRequest();
		  CollegeBean bean = filledForm.get();
		  College obj=bean.toEntity();
		  obj.save();
		  return ok(views.html.show.render());
	}
	public Result deleteCollege(Long collegeId){
		 
		College clg = College.find.byId(collegeId);
   	 Admin ad = Admin.find.where().in("collegeList", clg).findUnique();
   	 Logger.info("admin....."+ad.id);
   	 ad.collegeList.remove(clg);
   	
   	 ad.update();
   //`	clg.update();
   	//clg.delete();
    	// List<Patients> patient=Patients.find.orderBy().asc("patientId").findList();
    	 return ok("deleted");
    
    
}
	public Result updateCollege(Long collegeId){
		final Form<CollegeBean> filledForm = collegeBean.bindFromRequest();
		  CollegeBean bean = filledForm.get();
		College clg=College.find.byId(collegeId);
		// Admin ad = Admin.find.where().in("collegeList", clg).findUnique();
		// ad.collegeList.remove(clg);
		   	
	   Logger.info("------------dfdsfsdfsfsx-"+bean.collegeName);
		// College obj=bean.toEntity();
		//College obj=new College();
		//obj.id=bean.id;
		clg.name=bean.collegeName;
		clg.address=bean.address;
		// Logger.info(clg.address+"{{{{{{{");
		// Logger.info(clg.id+":::::");
		clg.update();
		return ok(views.html.show.render());
	}


	
	
}
