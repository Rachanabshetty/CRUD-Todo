package com.TodoList.todoCRUDproject.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TodoList.todoCRUDproject.error.TodoNotFoundException;
import com.TodoList.todoCRUDproject.model.TodoEntity;
import com.TodoList.todoCRUDproject.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService{

	@Autowired
	private TodoRepository todoRepository;

	@Override
	public TodoEntity saveTodo(TodoEntity todo) {
		return todoRepository.save(todo);	

}

	@Override
	public List<TodoEntity> fetchTodoList() {
		return todoRepository.findAll();
	}
	@Override
	public TodoEntity fetchTodoById(Long todoId) throws TodoNotFoundException {
	    return todoRepository.findById(todoId)
	            .orElseThrow(() -> new TodoNotFoundException("Todo with ID " + todoId + " not found"));
	}


	@Override
	public void deleteTodoById(Long todoId) {
	    if (!todoRepository.existsById(todoId)) {
	        throw new TodoNotFoundException("Todo with ID " + todoId + " not found");
	    }

	    todoRepository.deleteById(todoId);
	}



	@Override
	public TodoEntity updateTodoList(Long todoId, TodoEntity todoEntity) {

			TodoEntity tododb=todoRepository.findById(todoId).get();
			
			if(Objects.nonNull(todoEntity.getTitle())&&
					!"".equalsIgnoreCase(todoEntity.getTitle())) {
				tododb.setTitle(todoEntity.getTitle());
			}
			
			if(Objects.nonNull(todoEntity.getDescription())&&
					!"".equalsIgnoreCase(todoEntity.getDescription())) {
				tododb.setDescription(todoEntity.getDescription());
			}
			
			if(Objects.nonNull(todoEntity.getStatus())&&
					!"".equalsIgnoreCase(todoEntity.getStatus())) {
				tododb.setStatus(todoEntity.getStatus());
			}
			
			return todoRepository.save(tododb);
	

	}

	@Override
	public TodoEntity fetchTodoByTitle(String title) {
		return todoRepository.findByTitle( title);
	}
}


	

