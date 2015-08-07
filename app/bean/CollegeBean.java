package bean;

import java.io.Serializable;

import models.AppUser;
import models.College;
import play.Logger;

public class CollegeBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Long adminId;
	
    public Long getAdminId() {
		return adminId;
	}
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}


	public Long id;
	
	public String collegeName;
	public String address;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public College toEntity() {
		College obj = null;
		if (this.id != null) {
			obj = College.find.byId(id);
			
		} else {
			obj = new College();
			//obj.save();
		}

		if (this.collegeName != null) {
			obj.name = this.collegeName;

		}
		if (this.address != null) {
			obj.address = this.address;
		}
		
		
		return obj;
	}
    
}
