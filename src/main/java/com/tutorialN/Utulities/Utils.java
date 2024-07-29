package com.tutorialN.Utulities;

import java.util.Date;

public class Utils {
	
	
	public static  String emailWithDateStamp() {
		Date date = new Date();
		String emailDateStamp = date.toString().replace(":", "_").replace(" ", "_");
		return "benamroucheamina" + emailDateStamp + "@gmail.com";
				
	}
	
	
	public static final int IMPLICIT_WAIT = 10;
	public static final int PAGELOAD_TIMEOUTS = 10;
	public static final int SCRIPT_TIMEOUTS = 10;
	
	
	

}
