package com.karthik.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {
	
	private TodoService todoservice;
	private TodoRepository todorepository;
	

	public TodoControllerJpa(TodoService todoservice,TodoRepository todorepository) {
		super();
		this.todoservice = todoservice;
		this.todorepository=todorepository;
	}

	

	@RequestMapping("list-todos")
	public String listAlltodos(ModelMap model)
	{
		String username=getLoggedinUsername(model);
		List <ToDo> todos =todorepository.findByUsername(username);
		model.addAttribute("todos", todos);
		return "listTodos";
	}

	@RequestMapping(value="add-todo",method=RequestMethod.GET)
	public String showaddtodopage(ModelMap model)
	{
		String username=getLoggedinUsername(model);
		ToDo todo=new ToDo(0,username,"",LocalDate.now().plusYears(1),false);
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping("delete-todo")
	public String showdeletetodopage(@RequestParam int id)
	{
//		todoservice.deletetodo(id);
		todorepository.deleteById(id);
	
		return "redirect:list-todos";
	}
	@RequestMapping(value="update-todo",method=RequestMethod.GET)
	public String showupdatetodopage(@RequestParam int id,ModelMap model)
	{
		ToDo todo=todorepository.findById(id).get();
		model.addAttribute("todo",todo);
		//todoservice.udpatetodo(id);
		return "todo";
	}
	
	@RequestMapping(value="update-todo",method=RequestMethod.POST)
	public String updatetodopage(ModelMap model, @Valid ToDo todo, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "todo";
		}
		String username=getLoggedinUsername(model);
		todo.setUsername(username);
		todorepository.save(todo);
//		todoservice.updatetodo(todo);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="add-todo",method=RequestMethod.POST)
	public String addnewtodopage(ModelMap model, @Valid ToDo todo, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "todo";
		}
		String username=getLoggedinUsername(model);
		todo.setUsername(username);
		todorepository.save(todo);
//		todoservice.addtodo(username,todo.getDecription(), todo.getTargetDate(),todo.isDone());
		return "redirect:list-todos";
	}
	
	private String getLoggedinUsername(ModelMap model) {
		Authentication authentication=
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
