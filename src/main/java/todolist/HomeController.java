package todolist;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	@Autowired
	private TodoItemRepository todoItemRepository;

    @GetMapping("/")
    public String home(Model model) {
    	model.addAttribute("todoItem", new TodoItem());
    	Iterable<TodoItem> todoItems = todoItemRepository.findAll();
    	model.addAttribute("todoItems", todoItems);
        return "home";
    }

    @PostMapping
    public String addTodo(@ModelAttribute TodoItem todoItem) {
    	todoItemRepository.save(todoItem);
    	return "redirect:/";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<TodoItem> getAllTodoItems() {
    	return todoItemRepository.findAll();
    }

    @GetMapping("/itemDone/{id}")
    public String itemDone(@PathVariable(value="id") String id) {
    	TodoItem item = todoItemRepository.findById(Integer.parseInt(id)).get();
    	item.setDone(true);
    	todoItemRepository.save(item);

    	return "redirect:/";
    }

}
