package com.TodoList.todoCRUDproject.service;

import java.util.List;

import com.TodoList.todoCRUDproject.model.TodoEntity;

public interface TodoService {

	public TodoEntity saveTodo(TodoEntity todo);

	public List<TodoEntity> fetchTodoList();

	public TodoEntity fetchTodoById(Long todoId);

	public void deleteTodoById(Long todoId);

	public TodoEntity updateTodoList(Long todoId, TodoEntity todoEntity);

	public TodoEntity fetchTodoByTitle(String title);

}
