package controllers;

import java.util.List;

import models.AppUser;
import models.Video;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import bean.UserVideoBean;

public class UserVideoController extends Controller {
	

	public Result userVideo(){
		List<AppUser> userData = AppUser.find.orderBy().asc("id").findList();
		List<Video> videoData=Video.find.orderBy().asc("id").findList();
		
		return ok(views.html.uservideo.render(userData,videoData));
	}
	public Result saveUserVideo()
	{
		Form<UserVideoBean> form=Form.form(UserVideoBean.class).bindFromRequest();
		UserVideoBean bean=form.get();
		
		AppUser user=AppUser.find.byId(bean.userId);
	Video video=Video.find.byId(bean.videoId);

		user.videoList.add(video);
		user.update();
		return ok(" sucessful");
		
	}

}
