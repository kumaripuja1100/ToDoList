package com.todolist.todolist.dao.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class RegisteredResponse {
    private String userId;
    private String firstName;
    private String lastName;
}
