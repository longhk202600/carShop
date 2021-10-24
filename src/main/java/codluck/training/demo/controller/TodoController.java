package codluck.training.demo.controller;

import java.util.Optional;

import codluck.training.demo.model.Todo;
import codluck.training.demo.service.Impl.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/training")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "/listTodo", method = RequestMethod.GET)
    public String index(Model model, @RequestParam(value = "limit", required = false) Integer limit) {
        model.addAttribute("todoList", todoService.findAll(limit));
        return "listTodo";
    }

    @GetMapping("/addTodo")
    public String addTodo(Model model) {
        model.addAttribute("todo", new Todo());
        return "addTodo";
    }

    @PostMapping("/addTodo")
    public String addTodo(@ModelAttribute Todo todo) {
        return Optional.ofNullable(todoService.add(todo))
                .map(t -> "success")
                .orElse("failed");

    }
}
