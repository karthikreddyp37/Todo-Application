package com.karthik.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	
	private static List<ToDo> todos= new ArrayList<>();
	private static int todocount=0;
	
	static {
		todos.add(new ToDo(++todocount,"karthikrp","Learn springboot",LocalDate.now().plusYears(1),false));
		todos.add(new ToDo(++todocount,"karthikrp","Learn Aws",LocalDate.now().plusYears(2),false));
		todos.add(new ToDo(++todocount,"karthikrp","Learn Azure",LocalDate.now().plusYears(3),false));
	}
	
	public List<ToDo> findByUsername(String username)
	{
		Predicate<? super ToDo> predicate= todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	public void addtodo(String username,String description,LocalDate targetDate,boolean done)
	{
		ToDo todo=new ToDo(++todocount,username,description,targetDate,false);
		todos.add(todo);
	}
	
	public void deletetodo(int id)
	{		
		Predicate<? super ToDo> predicate= todo -> todo.getId()==id;
		todos.removeIf(predicate);
	}
	public ToDo findbyId(int id) {
		
		Predicate<? super ToDo> predicate= todo -> todo.getId()==id;
		ToDo todo =todos.stream().filter(predicate).findFirst().get();
		return todo;
	}
	public void updatetodo(@Valid ToDo todo) {
		deletetodo(todo.getId());
		todos.add(todo);
		
	}

}
