package com.example.demo;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RestController;  


@RestController  
public class WorldTimeController {
	
	@RequestMapping("/")  
	public String currentTime()   
	{  
	return new Date().toLocaleString();  
	}  
	
	
	@RequestMapping("/los-angeles") 
	public String dateTime() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("H:mm:ss");
		df.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
		String Tim = "LosAngeles Time : " + df.format(date);
		return Tim;
	}

}
