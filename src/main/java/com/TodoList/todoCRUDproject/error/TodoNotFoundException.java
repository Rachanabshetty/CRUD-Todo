package com.TodoList.todoCRUDproject.error;

@SuppressWarnings("serial")
public class TodoNotFoundException extends RuntimeException{

	public TodoNotFoundException(String message) {
        super(message);
    }

	  
}
