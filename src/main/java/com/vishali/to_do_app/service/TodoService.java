package com.vishali.to_do_app.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vishali.to_do_app.model.Todo;


import jakarta.validation.Valid;

@Service
public class TodoService {
	
	private static List<Todo> todos = new ArrayList<>();
	static int count = 0;
	static
	{
		todos.add(new Todo(++count,"Vishali","Learn AWS",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++count,"Vishali","Learn Python",LocalDate.now().plusYears(2),false));
		todos.add(new Todo(++count,"Vishali","Learn SpringBoot",LocalDate.now().plusYears(3),false));
	}
	
	public List<Todo> findByUsername(String username)
	{
		java.util.function.Predicate<? super Todo> predicate =
				todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}

	public void addToDo(String username, String description, LocalDate targetDate)
	{
		todos.add(new Todo(++count,username,description,targetDate,false));
		
	}
	
	public void deleteById(int id)
	{
		
		java.util.function.Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		java.util.function.Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo td = todos.stream().filter(predicate).findFirst().get();
		return td;
	
	}
	
	public void updateTodo(@Valid Todo todo)
	{
		deleteById(todo.getId());
		todos.add(todo);
	}
}
