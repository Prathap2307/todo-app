package io.schultz.dustin.todoapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.schultz.dustin.todoapp.model.ItemTest;
import io.schultz.dustin.todoapp.model.TodoItem;
import io.schultz.dustin.todoapp.model.TodoList;

@Repository
public interface ItemRepository  extends JpaRepository<TodoItem, Long>{
	

	

}
