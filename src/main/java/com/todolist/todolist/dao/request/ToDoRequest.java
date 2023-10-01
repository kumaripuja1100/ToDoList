package com.todolist.todolist.dao.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class ToDoRequest {
    private String heading;
    private String userId;
    private String content;
    private String style;
    private String color;

}
