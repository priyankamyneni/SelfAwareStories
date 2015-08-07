package controllers;

import models.Questionarie;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import bean.QuestionarieBean;

public class QuestionarieController extends Controller {
	
	public static final Form<QuestionarieBean> questionarieBean = Form.form(QuestionarieBean.class);
	
	public Result questionarie()
	{
		return ok(views.html.questionarie.render());
	}
	
	public Result saveQuestionarie(){
		Form<QuestionarieBean> form=Form.form(QuestionarieBean.class).bindFromRequest();
		QuestionarieBean bean=form.get();
		Questionarie questionarie=new Questionarie();
		questionarie.name=bean.name;
		questionarie.save();
		//List<Questionarie> quesList=Questionarie.find.all();
		return ok("ok");
		
	}

}
