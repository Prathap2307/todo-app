package testJ;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import io.schultz.dustin.todoapp.model.TodoItem;
import io.schultz.dustin.todoapp.model.TodoList;
import io.schultz.dustin.todoapp.repository.ItemRepository;
import io.schultz.dustin.todoapp.repository.TestRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)

public class TestRepositoryTest {

	@Autowired
	private TestRepository testRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Test
	public void saveTodoList() {
		TodoList todoListobj = new TodoList();

		todoListobj.setName("prathap");

		List<TodoItem> todoItemList = new ArrayList<>();

		TodoItem todoItemObj1 = new TodoItem();
		todoItemObj1.setItem("tyrtyrtyr");
		todoItemObj1.setComplete(false);

		todoItemList.add(todoItemObj1);

		// Map<String, List<TodoItem>> items = new HashMap<>(); //items.put("items",
		// todoItemList);

		todoListobj.setItems(todoItemList);
		TodoList savedObj = testRepository.save(todoListobj);
		// System.out.println("savedObj" +savedObj.ge );

		assertThat(todoListobj.getName()).isEqualTo(savedObj.getName());
	}

}
