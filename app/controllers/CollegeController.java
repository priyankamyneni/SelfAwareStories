/*package controllers;

import models.Admin;
import models.College;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import bean.AdminBean;
import bean.CollegeBean;

public class CollegeController extends Controller{
	
	public static final Form<CollegeBean> collegeBean = Form.form(CollegeBean.class);
	public static final Form<AdminBean> adminBean = Form.form(AdminBean.class);
	
public Result college(){
	
	
	Admin admin=Admin.find.where().eq("id",adminBean.get().id ).findUnique();
	return ok(views.html.college.render(admin));
		
		//return ok(views.html.college.render());
	
	}
public Result saveCollege()
{
	final Form<CollegeBean> filledForm = collegeBean.bindFromRequest();
	  CollegeBean bean = filledForm.get();
	  College obj=bean.toEntity();
	  obj.save();
	  return ok("college saved");
}

	public Result uploadFile(){
		College upload=new College();
		play.mvc.Http.MultipartFormData body = request().body().asMultipartFormData();
		DynamicForm form = Form.form().bindFromRequest();
	   String name = form.get("filename");
		FilePart photo = body.getFile("studentList");
		//String fileName = photo.getFilename();
		File file = photo.getFile();
		//File newFile = new File(play.Play.application().path().toString() + "//public//uploads//"+ "_" + fileName);
		//file.renameTo(newFile);       

		//System.out.println(newFile.getPath());
		try {
			upload.studentList=Files.toByteArray(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		upload.filename=name;	
		 upload.save();
		System.out.println(file.getPath());
		return ok("ok");
	}
	
	
}
*/