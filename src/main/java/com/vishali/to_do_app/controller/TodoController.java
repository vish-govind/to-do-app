package com.vishali.to_do_app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vishali.to_do_app.model.Todo;
import com.vishali.to_do_app.service.AuthenticationService;
import com.vishali.to_do_app.service.TodoService;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("name")
public class TodoController {
	
	private TodoService todo;
	private AuthenticationService authService;
	
	public TodoController(TodoService todo, AuthenticationService authService) {
		super();
		this.todo = todo;
		this.authService = authService;
	}
	
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model)
	{
		String username = authService.getLoggedinUsername();
		List<Todo> list_todo = todo.findByUsername(username);
		model.addAttribute("todos",list_todo);
		return "listTodo";
	}
	//Watch 139 and 140 videos
	
	@RequestMapping(value="add-todo", method = RequestMethod.GET)
	public String showAddNewTodoPage(ModelMap model)
	{
		String username = (String) model.get("name");
		Todo td = new Todo(0,username,"",LocalDate.now().plusYears(1),false);
		model.put("todo", td);
		return "addNewTodo";
	}
	
	@RequestMapping(value="add-todo", method = RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Todo td, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "addNewTodo";
		}
		String username = authService.getLoggedinUsername();
		System.out.println(username);
		todo.addToDo(username, td.getDescription(),td.getTargetDate());
		
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id)
	{
		todo.deleteById(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model)
	{
		Todo td = todo.findById(id);
		model.addAttribute("todo",td);
		return "addNewTodo";
	}

	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	public String UpdateTodo(ModelMap model, @Valid Todo td , BindingResult result)
	{
		if(result.hasErrors())
		{
			return "addNewTodo";
		}

		todo.updateTodo(td);
		
		return "redirect:list-todos";
	}

}
