package com.todolist.todolist.dao.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class ToDoResponse {
    private String heading;
    private String content;
    private String style;
    private String color;
}
