package com.TodoList.todoCRUDproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TodoList.todoCRUDproject.model.TodoEntity;
import com.TodoList.todoCRUDproject.service.TodoService;

@RestController
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@PostMapping("/todo")
	public TodoEntity saveTodo(@RequestBody TodoEntity todo) {
		return todoService.saveTodo(todo);
		
	}
	
	@GetMapping("/todo")
	public List<TodoEntity> fetchTodos() {
		return todoService.fetchTodoList();		
	}

	@GetMapping("/todo/{id}")
	public TodoEntity fetchTodoById(@PathVariable("id")Long todoId) {	
		return todoService.fetchTodoById(todoId);
				
	}
	
	@DeleteMapping("/todo/{id}")
	public String deleteTodoById(@PathVariable("id")Long todoId) {
		todoService.deleteTodoById(todoId);
		return "Todo deleted Successfully!!";
		
	}
	
	@PutMapping("/todo/{id}")
	public TodoEntity updateTodoList(@PathVariable("id")Long todoId,@RequestBody TodoEntity todoEntity) {
		return todoService.updateTodoList(todoId,todoEntity);
		
	}
	
	@GetMapping("todo/name/{name}")
	public TodoEntity fetchTodoByTitle(@PathVariable("name")String title) {
	
	return todoService.fetchTodoByTitle(title);
	
}
}
