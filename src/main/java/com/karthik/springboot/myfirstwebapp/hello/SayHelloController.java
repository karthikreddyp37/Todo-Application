package com.karthik.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SayHelloController {

	@RequestMapping("say-hello")
	@ResponseBody
	public String sayhello()
	{
		return "what are you doing today?";
	}
	
	@RequestMapping("say-html")
	@ResponseBody
	public String sayhtml()
	{
		StringBuffer sb= new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title> My first HTML page</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("My first html body");
		sb.append("</body>");
		sb.append("</html>");

		
		return sb.toString();
	}
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp()
	{
		return "sayHello";
	}
	
	
}
