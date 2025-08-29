package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Todo;
import com.example.demo.repository.TodoRepo;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class TodoController {
    @Autowired
    private TodoRepo todoRepo;


    @PostMapping("/add")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
       todoRepo.save(todo);
       return ResponseEntity.ok(todo);
    }

    
    @GetMapping("/todos")
    public List<Todo> getAllTodos() {
        return todoRepo.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public Todo deleteTodo(@PathVariable Long id) {
      Todo todo=  todoRepo.findById(id).orElse(null);
      if (todo != null) {
          todoRepo.deleteById(id);
      }
        return todo;
    }

}
