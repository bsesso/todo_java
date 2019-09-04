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

    	model.addAttribute("todoItems", todoItemRepository.findByDone(false));
        model.addAttribute("doneItems", todoItemRepository.findByDone(true));

        return "home";
    }

    @PostMapping("/addTodo")
    public String addTodo(@ModelAttribute TodoItem todoItem) {
    	todoItemRepository.save(todoItem);
    	return "redirect:/";
    }

    @GetMapping("/itemDone/{id}")
    public String itemDone(@PathVariable(value="id") String id) {
    	TodoItem item = todoItemRepository.findById(Integer.parseInt(id)).get();
    	item.setDone(true);
    	todoItemRepository.save(item);

    	return "redirect:/";
    }

    @GetMapping("/itemUndone/{id}")
    public String itemUndone(@PathVariable(value="id") String id) {
        TodoItem item = todoItemRepository.findById(Integer.parseInt(id)).get();
        item.setDone(false);
        todoItemRepository.save(item);

        return "redirect:/";
    }
}
