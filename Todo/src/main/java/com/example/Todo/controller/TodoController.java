package com.example.Todo.controller;

import com.example.Todo.model.Todo;
import com.example.Todo.service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/Todo-app")

public class TodoController {
    @Autowired
    private ITodoService todoService;
    @GetMapping("find-all")
    public List<Todo> findAll(){
        return todoService.findAll();
    }
    @PostMapping("add-todo")
    public  void AddTodo(@RequestBody Todo todo){
        todoService.addTodo(todo);
    }

    @GetMapping("findById/title/{title}")
    public Todo findByTitle(@PathVariable String  title){
        return todoService.findByTitle(title);

    }
    @DeleteMapping("deleteById/id/{id}")
    public  String  deleteById(@PathVariable int id){
        todoService.deleteById(id);
        return  "Todo deleted Successfully";
    }
    @GetMapping("findById/id/{id}")
    public  Todo findById(@PathVariable int id){
        return  todoService.findById(id);

    }
    @PutMapping("updateTodoById/id/{id}")
    public  String updateTodoById(@PathVariable int id, @RequestBody Todo todo){
        todoService.updateTodoById(id,todo);
        return "Todo Updated Successfully";
    }
}

