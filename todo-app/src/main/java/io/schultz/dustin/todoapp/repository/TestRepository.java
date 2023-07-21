package io.schultz.dustin.todoapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.schultz.dustin.todoapp.model.ItemTest;
import io.schultz.dustin.todoapp.model.TodoItem;
import io.schultz.dustin.todoapp.model.TodoList;

@Repository
public interface TestRepository extends JpaRepository<TodoList, Long> {
	/*
	 * @Query(value = "Select * from TODO_ITEM", nativeQuery = true)
	 * 
	 * @Query("Select new com.pluralsight.model.GoalReport(g.minutes, e.minutes, e.activity) "
	 * + "from Goal g, Exercise e where g.id = e.goal.id")
	 */

	@Query("Select new io.schultz.dustin.todoapp.model.ItemTest(tl.item)" + "from TodoItem tl, "
			+ "TodoItem ti where tl.id = ti.id and tl.id = 1")
	List<ItemTest> findAllGoalReports();

	@Query(value = "Select * from TODO_LIST", nativeQuery = true)
	List<TodoList> findAllRecord1();

	@Query("Select ti.name from TodoList ti")
	List<TodoList> findAllRecord2();

	/*
	 * @Query(value= "Select * from TODO_LIST", nativeQuery = true) List<TodoList>
	 * findAllRecord2();
	 */

}

/*
 * @Repository("goalRepository") public interface GoalRepository extends
 * JpaRepository<Goal, Long> {
 * 
 * @Query("Select new com.pluralsight.model.GoalReport(g.minutes, e.minutes, e.activity) "
 * + "from Goal g, Exercise e where g.id = e.goal.id") List<GoalReport>
 * findAllGoalReports();
 * 
 * }
 */
