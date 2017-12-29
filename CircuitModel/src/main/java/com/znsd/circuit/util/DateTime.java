package com.znsd.circuit.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {
	
	public String getDateTime() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return sdf.format(new Date());
	}

}
