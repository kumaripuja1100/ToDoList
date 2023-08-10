package com.todolist.todolist.repository;

import com.todolist.todolist.dao.response.ToDoResponse;
import com.todolist.todolist.entity.UserData;
import jakarta.persistence.OrderBy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoListRepository extends JpaRepository<UserData, Long>{

    UserData findUserDataById(Long id);

    @OrderBy("updateTime DESC")
    List<UserData> findAllByOrderByUpdateTimeDesc();
}
