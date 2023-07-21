package io.schultz.dustin.todoapp.controller;

import io.schultz.dustin.todoapp.dto.TodoListDto;
import io.schultz.dustin.todoapp.exceptions.ItemsNullException;
import io.schultz.dustin.todoapp.exceptions.MyResourceNotFoundException;
import io.schultz.dustin.todoapp.exceptions.ProductNotfoundException;
import io.schultz.dustin.todoapp.model.ItemTest;
import io.schultz.dustin.todoapp.model.TodoItem;
import io.schultz.dustin.todoapp.model.TodoList;
import io.schultz.dustin.todoapp.repository.ItemRepository;
import io.schultz.dustin.todoapp.repository.TestRepository;
import io.schultz.dustin.todoapp.repository.TodoRepository;
import io.schultz.dustin.todoapp.service.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/todo")
@ControllerAdvice
public class TodoController {

	private TodoService todoService;

	@Inject
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@GetMapping("/lists")
	public List<TodoListDto> getTodoLists() {
		return todoService.getTodoLists();
	}

	@Autowired
	private TestRepository testRepository;
	private ItemRepository itemRepository;
	// private TodoRepository todoRepository;

	@GetMapping("/listsTest")
	public List<TodoList> getTest() {
		return testRepository.findAll();
	}

	@GetMapping("/listsItem")
	public List<ItemTest> getListsItem() {
		return testRepository.findAllGoalReports();
	}
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TodoController.class);
	
	@GetMapping("/service1")
	public List<TodoList> findAllRecord1() {
		try {
			System.out.println("tracing -----------------------------------> ");
			LOGGER.info("for tracing purpose");
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		return testRepository.findAllRecord1();
	}
	
	@GetMapping("/service2")
	public List<TodoList> findAllRecord2() {
		return testRepository.findAllRecord2();
	}

	@PostMapping("/saveList")
	public TodoList saveList(@RequestBody TodoList todoList)  {

		
		
		return testRepository.save(todoList);
		
		
	}
	
	
	@PostMapping("/saveListWithException")
	public TodoList saveListWithException(@RequestBody TodoList todoList)  {

		
		
		if(todoList.getItems().size() == 0)  {
			System.out.println("if inside");
			
			throw new ItemsNullException();
		}
		
		return testRepository.save(todoList);
		
		
	}

}
