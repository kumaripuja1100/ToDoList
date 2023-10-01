package com.todolist.todolist.service.serviceImpl;

import com.todolist.todolist.dao.request.RegisteredRequest;
import com.todolist.todolist.dao.request.ToDoRequest;
import com.todolist.todolist.dao.response.RegisteredResponse;
import com.todolist.todolist.dao.response.ToDoResponse;
import com.todolist.todolist.entity.RegisteredUser;
import com.todolist.todolist.entity.UserData;
import com.todolist.todolist.exception.RequestNotFound;
import com.todolist.todolist.repository.RegisteredRepository;
import com.todolist.todolist.repository.ToDoListRepository;
import com.todolist.todolist.service.ToDoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoListServiceImpl implements ToDoListService {

    private final ToDoListRepository toDoListRepository;
    private final RegisteredRepository registeredRepository;

    public void addUser(RegisteredRequest request){
        RegisteredUser registeredUser;
        if(registeredRepository.existsRegisteredUserByUserId(request.getUserId())){
            throw new RequestNotFound("user already registered");
        }
        else{
            registeredRepository.save(registeredUser = RegisteredUser.builder()
                            .userId(request.getUserId())
                            .firstName(request.getFirstName())
                            .lastName(request.getLastName())
                    .build());
        }
    }
    public RegisteredResponse viewUser(String request){
        if(registeredRepository.existsRegisteredUserByUserId(request)){
            var x = registeredRepository.findRegisteredUserByUserId(request).get(0);
            RegisteredResponse registeredResponse = new RegisteredResponse();
            registeredResponse.setUserId(x.getUserId());
            registeredResponse.setLastName(x.getLastName());
            registeredResponse.setFirstName(x.getFirstName());
            return registeredResponse;
        }else {
            throw new RequestNotFound("userData not found");
        }
    }

    @Override
    public Long addToDo(ToDoRequest request) {

        UserData userData;

        toDoListRepository.save(userData = UserData.builder()
                .style(request.getStyle())
                .color(request.getColor())
                .content(request.getContent())
                .heading(request.getHeading())
                .userId(request.getUserId())
                .build());

        return userData.getId();

    }

    public ToDoResponse viewToDo(Long request) {
        if(toDoListRepository.existsById(request)){
            UserData x = toDoListRepository.findUserDataById(request);
            ToDoResponse toDoResponse = new ToDoResponse();
            toDoResponse.setColor(x.getColor());
            toDoResponse.setHeading(x.getHeading());
            toDoResponse.setContent(x.getContent());
            toDoResponse.setStyle(x.getStyle());
            toDoResponse.setId(x.getId());
            return  toDoResponse;
        } else {
            throw new RequestNotFound("Id does not exist in database");
        }
    }

     public List<ToDoResponse> viewAllToDo(String userId) {
        List<UserData> x = toDoListRepository.findUserDataByUserId(userId);
         List<ToDoResponse> toDoResponselist = new ArrayList<ToDoResponse>();
         for (var data: x) {
             ToDoResponse toDoResponse = new ToDoResponse();

             toDoResponse.setColor(data.getColor());
             toDoResponse.setHeading(data.getHeading());
             toDoResponse.setContent(data.getContent());
             toDoResponse.setStyle(data.getStyle());
             toDoResponse.setId(data.getId());
             toDoResponselist.add(toDoResponse);
         }

            return toDoResponselist;
     }
    public void updateToDo(Long request, ToDoRequest updatedRequest) {
        if(toDoListRepository.existsById(request)) {
            UserData x = toDoListRepository.findUserDataById(request);
            x.setColor(updatedRequest.getColor());
            x.setStyle(updatedRequest.getStyle());
            x.setHeading(updatedRequest.getHeading());
            x.setContent(updatedRequest.getContent());
            toDoListRepository.save(x);
        } else {
            throw new RequestNotFound("Id does not exist in database");
        }
    }
    public void deleteToDo(Long request) {
        if(toDoListRepository.existsById(request)) {
            toDoListRepository.deleteById(request);
        } else {
            throw new RequestNotFound("Id does not exist in database");
        }
    }
}