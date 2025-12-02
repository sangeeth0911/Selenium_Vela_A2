package com.DemoWebShop_GenericUtility;

import java.time.LocalDateTime;

public class JavaUtility {
	
	public String localDateAndTime() {
		String time = LocalDateTime.now().toString().replace(".","").replace(":","").replace("-","");
		return time;
	}

}
