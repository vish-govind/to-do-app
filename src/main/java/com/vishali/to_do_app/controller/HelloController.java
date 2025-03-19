package com.vishali.to_do_app.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {
	
	@RequestMapping("hello")
	@ResponseBody
	public String sayHello()
	{
		return "Hello";
	}
	
	@RequestMapping("hello-html")
	@ResponseBody
	public String sayHelloHtml()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>Hello HTML</title>");
		sb.append("</head>");
		sb.append("<body>HTML inside String Buffer</body>");
		sb.append("</html>");
	
		return sb.toString();
	}
	
	@RequestMapping("hello-jsp")
	public String sayHelloJsp()
	{
		return "sayHello";
	}
	
	//http://localhost:8080/hello-vishali?name=Vishali
	@RequestMapping("hello-vishali")
	public String gotoLoginPage(@RequestParam String name , ModelMap model)
	{
		model.put("name", name);
		return "sayHello";
	}

}
