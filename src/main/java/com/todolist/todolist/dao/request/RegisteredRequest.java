package com.todolist.todolist.dao.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class RegisteredRequest {
    private String userId;
    private String firstName;
    private String lastName;
}
