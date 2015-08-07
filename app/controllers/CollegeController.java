package controllers;

import java.io.File;
import java.io.IOException;

import models.College;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Result;
import bean.CollegeBean;

import com.google.common.io.Files;

public class CollegeController extends Controller{
	
	public static final Form<CollegeBean> collegeBean = Form.form(CollegeBean.class);
	
public Result college(){
		
		return ok(views.html.college.render());
	
	}
public Result saveCollege()
{
	final Form<CollegeBean> filledForm = collegeBean.bindFromRequest();
	  CollegeBean bean = filledForm.get();
	  College obj=bean.toEntity();
	  obj.save();
	  return ok("college saved");
}

	/*public Result uploadFile(){
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
	}*/
	
	
}
