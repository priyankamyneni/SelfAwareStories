package bean;

import java.io.Serializable;

public class VideoQuestionaryBean implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public Long videoId;
public Long questionarieId;

public Long getVideoId() {
	return videoId;
}
public void setVideoId(Long videoId) {
	this.videoId = videoId;
}
public Long getQuestionarieId() {
	return questionarieId;
}
public void setQuestionarieId(Long questionarieId) {
	this.questionarieId = questionarieId;
}
}
