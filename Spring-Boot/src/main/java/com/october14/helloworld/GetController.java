package com.october14.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GetController {
	
	String msg="Welcome %s";
	
	@GetMapping("/getName")
	@ResponseBody
	public Person getPerson( @RequestParam(name="name", required=false, defaultValue="Swati")String name ) {
		
		return new Person(String.format(msg, name));
		
	}
	
}
