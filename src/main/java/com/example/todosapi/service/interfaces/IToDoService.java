package com.example.todosapi.service.interfaces;

import com.example.todosapi.data.dto.ToDoDTO;

import java.util.List;
import java.util.Optional;

public interface IToDoService {
    List<ToDoDTO> searchAllToDos();
    Optional<ToDoDTO> searchToDoById(Long id);
    void saveNewToDo(ToDoDTO newToDo);
    ToDoDTO updateToDo(Long id, ToDoDTO toDoUpdated);

    ToDoDTO deleteToDoById(Long id);
}
