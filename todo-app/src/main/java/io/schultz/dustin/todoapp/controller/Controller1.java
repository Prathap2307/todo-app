package io.schultz.dustin.todoapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.schultz.dustin.todoapp.dto.TodoListDto;
import io.schultz.dustin.todoapp.model.TodoList;
import io.schultz.dustin.todoapp.repository.OneRepsitory;



@RestController
public class Controller1 {

	@Autowired
	public OneRepsitory oneRepsitory;
	
	
	@Autowired
	private BeanTest BeanTestPP;
	
	@Autowired
	@Qualifier("appleComponent")
	private BeanTestInterface beanTestInterfacePP;
	
	@GetMapping("/whichComponentTest")
	public String orangeComponentTest() {
	
			return	beanTestInterfacePP.findWhichFruit();
		
	}
	
	

	@GetMapping("/oneLists/{name}")
	public List<TodoList> oneLists(@PathVariable String name) {
		System.out.println(" name -->" + name);
		return oneRepsitory.findByNameContaining(name);
	}

	public Map<Integer, String> testObj = new HashMap<Integer, String>();

	@RequestMapping(value = "/testHash", method = RequestMethod.GET)
	public Map<Integer, String> testHash() {

		testObj.put(1, "test");
		testObj.put(2, "test2");
		testObj.put(3, "test2");
		// testObj.put(null, "test4");

		return testObj;
	}

	@RequestMapping(value = "/testHashMapResponseEntity", method = RequestMethod.GET)
	public ResponseEntity<Map<Integer, String>> testHashMapResponseEntity() {

		System.out.println("appName.getName() -->" + app.getName());
		// System.out.println("appName.getName() -->" + app.getDataBase());

		Map<Integer, String> response = new HashMap<>();
		response.put(1, "test");
		response.put(2, "test2");
		response.put(3, null);

		return ResponseEntity.accepted().body(response);

		/*
		 * testObj.put(1, "test"); testObj.put(2, "test2"); testObj.put(3, "test2");
		 * testObj.put(null, "test4");
		 * 
		 * return testObj;
		 */
	}

	/*
	 * @PostMapping(value ="/oneLists") public TodoList oneLists(@RequestBody
	 * TodoList todoList) { return oneRepsitory.getOne(todoList.getId()); }
	 */

	@Bean
	public AppName getAppNameTest(@Value("${log.location}") String a) {
		 System.out.println("appName -->" + a);
		return () -> a;
	}


	@Autowired
	private AppName app;
	
	
	//private BeanTestInterface beanTestInterface;

	
	

}

// POSTMAN

/* localhost:8080/whichComponentTest */



