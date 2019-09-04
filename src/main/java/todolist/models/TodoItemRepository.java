package todolist;

import org.springframework.data.repository.CrudRepository;

import todolist.TodoItem;
import java.util.List;

public interface TodoItemRepository extends CrudRepository<TodoItem, Integer> {
	public List<TodoItem> findByContentContaining(String content);
	public List<TodoItem> findByDone(boolean done);
}