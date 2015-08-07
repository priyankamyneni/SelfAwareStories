package controllers;

import java.util.List;

import models.Questionarie;
import models.Video;
import models.VideoQuestionarie;
import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import bean.VideoQuestionaryBean;

public class VideoQuestionarieController extends Controller{
	
	
	//public static final Form<VideoBean> videoBean = Form.form(VideoBean.class);
	
	public Result videoQuestionarie(){
		List<Video> videoList=Video.find.orderBy().asc("id").findList();
		List<Questionarie> questionarieList=Questionarie.find.orderBy().asc("id").findList();
		
		return ok(views.html.videoQuestionary.render(videoList,questionarieList));
	}
	public Result saveVideoQuestionarie()
	{
		Form<VideoQuestionaryBean> form=Form.form(VideoQuestionaryBean.class).bindFromRequest();
		VideoQuestionaryBean bean=form.get();
		VideoQuestionarie videoQuestionary= new VideoQuestionarie();
		Questionarie ques=Questionarie.find.byId(bean.questionarieId);
		Video vi=Video.find.byId(bean.videoId);
      videoQuestionary.video=vi;
      Logger.info(videoQuestionary.video+"======================================================================");
		videoQuestionary.questionarie=ques;
		
		Logger.info(vi.id+"");
		Logger.info(ques.id+"====+++++++++++++++++++++++++++++++++++++++++++++");
		Logger.info("videoQuestonary saving");
		videoQuestionary.save();
		Logger.info("videoQuestonary saved");
		return ok("videoQuestonary ok ");
	}
	

}
