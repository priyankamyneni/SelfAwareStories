package controllers;

import models.AppUser;
import models.Blog;
import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import bean.BlogBean;

public class BlogController extends Controller{
	
	
	public static final Form<BlogBean> blogBean = Form.form(BlogBean.class);
	
	public Result blog()
	{  
		return ok(views.html.blog.render());
	}
	public Result saveBlog()
	{
		Form<BlogBean> form=Form.form(BlogBean.class).bindFromRequest();
		BlogBean bean=form.get();
		Blog blog=new Blog();
		blog.name=bean.name;
		blog.description=bean.description;
		
		AppUser user=AppUser.find.where().eq("id",bean.userId).findUnique();
		Logger.info(user.id+"==");
		user.blogList.add(blog);
		user.update();
		blog.save();
		return ok("ok");
		
		
	}

}
