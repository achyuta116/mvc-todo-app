package com.example.mvcooad.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mvcooad.services.TodoService;
import com.example.mvcooad.dto.TodoContent;
import com.example.mvcooad.model.Todo;


/**
 * TodoController
 */

@RestController
@RequestMapping("/todos")
public class TodoController {


    @Autowired private TodoService todoService;

    @GetMapping("/")
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping("/{id}")
    public Todo getTodos(@PathVariable Long id) {
        return todoService.getTodo(id);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@RequestBody String description, @PathVariable Long id) {
        return todoService.updateTodo(description, id);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }

    @PostMapping("/")
    public Todo Todo(@RequestBody TodoContent content) {
        return todoService.createTodo(content.getDescription(), content.getTitle());
    }
}
