package controllers;

import models.Question;
import models.Questionarie;
import play.Logger;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import bean.QuestionBean;

public class QuestionController extends Controller{
	
	public Result question()
	{  
		return ok(views.html.question.render());
	}
	
	public Result saveQuestion(){
		Form<QuestionBean> form=Form.form(QuestionBean.class).bindFromRequest();
		QuestionBean bean=form.get();
		Logger.info(bean.qid+"==");
		Questionarie ques=Questionarie.find.where().eq("id",bean.qid).findUnique();
		
		Question question=new Question();
		question.question=bean.question;
		question.option1=bean.option1;
		question.option2=bean.option2;
		question.option3=bean.option3;
		question.option4=bean.option4;
		question.correctAnswer=bean.correctAnswer;
		
		ques.questionList.add(question);
		ques.update();
	
		question.save();
		return ok("ok");
		
	}

}
