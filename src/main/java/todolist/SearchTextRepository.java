package todolist;

import org.springframework.data.repository.CrudRepository;

import todolist.SearchText;

public interface SearchTextRepository extends CrudRepository<SearchText, Integer> {

}