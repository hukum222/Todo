package com.example.Todo.service;


import com.example.Todo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService  implements ITodoService{
    private  static List<Todo> todos=new ArrayList<>();
    static {
        Todo t1=new Todo(1,"washing",true);
        Todo t2=new Todo(2,"driving",true);
        Todo t3=new Todo(3,"spa",false);
        Todo t4=new Todo(4,"sky diving",true);
        Todo t5=new Todo(5,"boating",true);
        todos.add(t1);
        todos.add(t2);
        todos.add(t3);
        todos.add(t4);
        todos.add(t5);


    }
    @Override
    public  List<Todo> findAll(){
        return todos;
    }
    @Override
    public  void addTodo(Todo todo){
        todos.add(todo);
    }
    @Override
    public Todo findByTitle(String title){
        for(Todo todo:todos){
            if(todo.getTitle().equals(title)){
                return todo;
            }
        }
        return  null;
    }

    @Override

    public  void deleteById(int id){
        for(Todo todo:todos){
            if(todo.getId()==id){
                todos.remove(todo);
            }
        }
    }

    @Override
    public  Todo findById  (int id){
        for(Todo todo:todos){
            if(todo.getId()==id){
                return todo;
            }
        }
        return  null;
    }
    @Override
    public void updateTodoById(int id,Todo newtodo){
        Todo todo=findById(id);
        todo.setId(newtodo.getId());
        todo.setStatus(newtodo.isStatus());
        todo.setTitle(newtodo.getTitle());
    }
}