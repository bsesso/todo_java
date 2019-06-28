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
public class SearchController {
	@Autowired
	private TodoItemRepository todoItemRepository;

    @GetMapping("/search")
    public String searchPage(Model model) {
    	model.addAttribute("searchText", new SearchText());

        return "search";
    }

    @PostMapping("/search/results")
    public String doSearch(@ModelAttribute SearchText searchText) {
        System.out.println(searchText.getText());

    	return "redirect:/";
    }
}
