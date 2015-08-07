package bean;

import java.io.Serializable;

import models.TypeOfVideo;



public class VideoBean implements Serializable{
	

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Long id;
	
	public String name;
	

	public String description;
	
	public String typeOfVideo;
	
	public Long vimeoCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public String getTypeOfVideo() {
		return typeOfVideo;
	}

	public void setTypeOfVideo(String typeOfVideo) {
		this.typeOfVideo = typeOfVideo;
	}

	public Long getVimeoCode() {
		return vimeoCode;
	}

	public void setVimeoCode(Long vimeoCode) {
		this.vimeoCode = vimeoCode;
	}
	
	
	
}
