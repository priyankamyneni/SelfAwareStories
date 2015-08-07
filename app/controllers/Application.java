package controllers;


import java.util.List;

import models.AppUser;
import models.Blog;
import models.Question;
import models.Questionarie;
import models.TypeOfVideo;
import models.Video;
import models.VideoQuestionarie;
import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import bean.AppUserBean;
import bean.BlogBean;
import bean.QuestionBean;
import bean.QuestionarieBean;
import bean.UserVideoBean;
import bean.VideoBean;
import bean.VideoQuestionaryBean;



public class Application extends Controller{
	public Result index(){
		return ok(views.html.index.render());

		//return ok(views.html.appUser.render("Your new application is ready."));
	}
	

	
	
	
/*public Result situationalVideo(){
		
		return ok();
	
	}

public Result copingVideo(){
	
	return ok();

}*/


	
/*	public Result insertSituationVideo(){
		final Form<SituationVideoBean> videoForm=situationVideoBean.bindFromRequest();
		
		if (videoForm.hasErrors()) {
			return ok();
		} else {
		SituationVideoBean bean=videoForm.get();
		
		
		SituationVideo situationVideo = new SituationVideo();
		situationVideo.name = bean.name;
		situationVideo.vimeoCode=bean.vimeoCode;
		situationVideo.description=bean.description;
		situationVideo.save();
		}
	return ok("ok");	
	}*/
	
	

	
	
		
	}


