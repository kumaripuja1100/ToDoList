package com.todolist.todolist.repository;

import com.todolist.todolist.dao.request.ToDoRequest;
import com.todolist.todolist.entity.RegisteredUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisteredRepository extends JpaRepository<RegisteredUser, Long> {
    List<RegisteredUser> findRegisteredUserByUserId(String userId);
    Boolean existsRegisteredUserByUserId(String userId);
}
