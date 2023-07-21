package io.schultz.dustin.todoapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import io.schultz.dustin.todoapp.model.TodoList;

@Repository
public interface OneRepsitory extends JpaRepository<TodoList, Long> {
	 List<TodoList> findByNameContaining(String name);
	
}
