package com.todolist.todolist.controller;

import com.todolist.todolist.dao.request.RegisteredRequest;
import com.todolist.todolist.dao.request.ToDoRequest;
import com.todolist.todolist.dao.response.RegisteredResponse;
import com.todolist.todolist.dao.response.ToDoResponse;
import com.todolist.todolist.service.ToDoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
@CrossOrigin(origins = "https://mytodowebsite.onrender.com/")
public class ToDoController {

    private final ToDoListService toDoListService;

    @PostMapping("/add_ToDo")
    public ResponseEntity<Long> addToDo(@RequestBody ToDoRequest request) {
        return ResponseEntity.ok().body(toDoListService.addToDo(request));
    }
    @PostMapping("/add_user")
    public ResponseEntity addUser(@RequestBody RegisteredRequest request){
        toDoListService.addUser(request);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/view_user/{userId}")
    public ResponseEntity<RegisteredResponse> viewUser(@PathVariable("userId") String request){
        return ResponseEntity.ok().body(toDoListService.viewUser(request));
    }
    @GetMapping("/view_ToDo/{id}")
    public ResponseEntity<ToDoResponse> viewToDo(@PathVariable("id") Long request) {
        return ResponseEntity.ok().body(toDoListService.viewToDo(request));
    }

    @GetMapping("/viewAll_ToDo/{userId}")
    public ResponseEntity<List<ToDoResponse>> viewAll(@PathVariable("userId") String request) {
        return ResponseEntity.ok().body(toDoListService.viewAllToDo(request));
    }

    @PutMapping("/update_ToDo/{id}")
    public ResponseEntity updateToDo(@PathVariable("id") Long request, @RequestBody ToDoRequest updatedRequest) {
        toDoListService.updateToDo(request, updatedRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete_ToDo/{id}")
    public ResponseEntity deleteToDo(@PathVariable("id") Long request) {
        toDoListService.deleteToDo(request);
        return ResponseEntity.ok().build();
    }
}
