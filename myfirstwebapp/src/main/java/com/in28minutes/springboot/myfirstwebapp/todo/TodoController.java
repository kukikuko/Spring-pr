package com.in28minutes.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

//@Controller
@SessionAttributes("name")
public class TodoController {

    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    private TodoService todoService;


    @RequestMapping("/list-todos")
    public String listAllTodos(ModelMap modelMap) {
        String userName = getLoggedInUserName(modelMap);
        List<Todo> todos = todoService.findByUserName(userName);
        modelMap.addAttribute("todos", todos);

        return "listTodos";
    }

    @RequestMapping("/add-todo")
    public String showNewTodoPage(ModelMap modelMap) {
        String userName = getLoggedInUserName(modelMap);
        Todo todo = new Todo(0, userName, "", LocalDate.now().plusYears(1), false);
        modelMap.put("todo", todo);
        return "todo";
    }


    @PostMapping("/add-todo")
    public String addTodo(ModelMap modelMap, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        String userName = getLoggedInUserName(modelMap);
        todoService.addTodo(userName, todo.getDescription(), todo.getTargetDate(), false);
        return "redirect:list-todos";
    }

    @RequestMapping("/delete-todo")
    public String deleteTodo(@RequestParam int id) {
        todoService.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping("/update-todo")
    public String showUpdateTodoPage(@RequestParam int id, ModelMap modelMap) {
        Todo todo = todoService.findById(id);
        modelMap.addAttribute("todo", todo);
        return "todo";
    }

    @PostMapping("/update-todo")
    public String updateTodo(ModelMap modelMap, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        String userName = getLoggedInUserName(modelMap);
        todo.setUserName(userName);
        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }

    private String getLoggedInUserName(ModelMap modelMap) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

}
