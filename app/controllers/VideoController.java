package controllers;

import models.TypeOfVideo;
import models.Video;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import bean.VideoBean;

public class VideoController extends Controller {
	
	public static final Form<VideoBean> videoBean = Form.form(VideoBean.class);
	

	public Result video()
	{
		return ok(views.html.video.render());
	}
	public Result insertVideo(){
		final Form<VideoBean> videoForm=videoBean.bindFromRequest();
		
		/*if (videoForm.hasErrors()) {
			return ok();
		} else {*/
		VideoBean bean=videoForm.get();
		
		
		Video video = new Video();
		video.name = bean.name;
		
		if("situation".equals(bean.getTypeOfVideo())){
			video.typeOfVideo=TypeOfVideo.SITUATIONALVIDEO;
		}
		if("coping".equals(bean.getTypeOfVideo())){
			video.typeOfVideo=TypeOfVideo.COPINGVIDEO;
		}
		
		video.vimeoCode=bean.vimeoCode;
		video.description=bean.description;
		
		
		video.save();
	
		
	return ok("ok");	
	}
	
}
