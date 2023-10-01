package com.todolist.todolist.service;

import com.todolist.todolist.dao.request.RegisteredRequest;
import com.todolist.todolist.dao.request.ToDoRequest;
import com.todolist.todolist.dao.response.RegisteredResponse;
import com.todolist.todolist.dao.response.ToDoResponse;

import java.util.List;

public interface ToDoListService {
    Long addToDo(ToDoRequest request);
    ToDoResponse viewToDo(Long request);
    void updateToDo(Long request, ToDoRequest updatedRequest);
    void deleteToDo(Long request);
    void addUser(RegisteredRequest request);
    RegisteredResponse viewUser(String userId);
    List<ToDoResponse> viewAllToDo(String userId);

}
