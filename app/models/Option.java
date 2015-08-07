package models;

import com.avaje.ebean.annotation.EnumValue;

public enum Option {
	
	@EnumValue("CORRECT")
	CORRECT,
   
	@EnumValue("PARTIALLY")
	PARTIALLY,
	
	@EnumValue("WRONG")
	WRONG,
	
	 

}
