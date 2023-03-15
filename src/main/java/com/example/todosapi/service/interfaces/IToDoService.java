package com.example.todosapi.service.interfaces;

import com.example.todosapi.data.entity.ToDo;

import java.util.List;
import java.util.Optional;

public interface IToDoService {
    List<ToDo> searchAllToDos();
    Optional<ToDo> searchToDoById(Long id);
    ToDo saveNewToDo(ToDo newToDo);
    ToDo updateToDo(Long id, ToDo toDoUpdated);

    ToDo deleteToDoById(Long id);
}
