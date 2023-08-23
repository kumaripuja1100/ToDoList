package com.todolist.todolist.controller;

import com.todolist.todolist.dao.request.ToDoRequest;
import com.todolist.todolist.dao.response.ToDoResponse;
import com.todolist.todolist.service.ToDoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor

public class ToDoController {

    private final ToDoListService toDoListService;

    @PostMapping("/add_ToDo")
    public ResponseEntity<Long> addToDo(@RequestBody ToDoRequest request) {
        return ResponseEntity.ok().body(toDoListService.addToDo(request));
    }

    @GetMapping("/view_ToDo/{id}")
    public ResponseEntity<ToDoResponse> viewToDo(@PathVariable("id") Long request) {
        return ResponseEntity.ok().body(toDoListService.viewToDo(request));
    }

    @GetMapping("/viewAll_ToDo")
    public ResponseEntity<List<ToDoResponse>> viewAll() {
        return ResponseEntity.ok().body(toDoListService.viewAllToDo());
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
