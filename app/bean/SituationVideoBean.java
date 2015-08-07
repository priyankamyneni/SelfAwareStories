package bean;

import java.io.Serializable;

public class SituationVideoBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Long id;

	public Long vimeoCode;
	
	public String name;
	
	public String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVimeoCode() {
		return vimeoCode;
	}

	public void setVimeoCode(Long vimeoCode) {
		this.vimeoCode = vimeoCode;
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

}
