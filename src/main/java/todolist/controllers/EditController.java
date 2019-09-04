package todolist;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class EditController {
	@Autowired
	private TodoItemRepository todoItemRepository;

    @GetMapping("/todo/{id}")
    public String edit(@PathVariable(value="id") String id, Model model) {
    	TodoItem item = todoItemRepository.findById(Integer.parseInt(id)).get();
    	model.addAttribute("todoItem", item);
    	return "edit";
    }

    @PostMapping("/todo/{id}/save")
    public String saveTodo(@PathVariable(value="id") String id, @ModelAttribute TodoItem todoItem) {
    	TodoItem item = todoItemRepository.findById(Integer.parseInt(id)).get();
    	item.setContent(todoItem.getContent());
        item.setDate(todoItem.getDate());
    	todoItemRepository.save(item);
    	return "redirect:/";
    }
}