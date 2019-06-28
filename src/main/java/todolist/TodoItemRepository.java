package todolist;

import org.springframework.data.repository.CrudRepository;

import todolist.TodoItem;

public interface TodoItemRepository extends CrudRepository<TodoItem, Integer> {

}