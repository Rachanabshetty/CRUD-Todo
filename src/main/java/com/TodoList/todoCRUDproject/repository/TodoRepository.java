package com.TodoList.todoCRUDproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.TodoList.todoCRUDproject.model.TodoEntity;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
	
	public TodoEntity findByTitle(String title);
	
	public TodoEntity findByTitleIgnoreCase(String title);

}
