package com.example.mvcooad.services;

import com.example.mvcooad.model.Todo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TodoService
 */

@Service
public class TodoService {

    @Autowired private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        List<Todo> result = new ArrayList<Todo>();
        todoRepository.findAll().forEach(result::add);
        return result;
    }

    public Todo getTodo(Long id) { return todoRepository.findById(id).get(); }

    public void deleteTodo(Long id) { todoRepository.deleteById(id); }

    public Todo updateTodo(String desc, Long id) {
        Todo todo = todoRepository.findById(id).get();
        todo.setDescription(desc);
        return todoRepository.save(todo);
    }

    public Todo createTodo(String desc, String title) {
        Todo todo = new Todo();
        todo.setDescription(desc);
        todo.setTitle(title);
        return todoRepository.save(todo);
    }
}
