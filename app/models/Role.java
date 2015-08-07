package models;

import com.avaje.ebean.annotation.EnumValue;

public enum Role {
	    
	   @EnumValue("ADMIN")
		ADMIN,
	   
		@EnumValue("GUESTUSER")
		GUESTUSER,
		
		@EnumValue("REGISTEREDUSER")
		REGISTEREDUSER,
		
		@EnumValue("SUBSCRIBEDUSER")
		SUBSCRIBEDUSER,
		
		@EnumValue("MODERATOR")
	    MODERATOR  
}
