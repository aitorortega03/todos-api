package com.example.todosapi.data.mapper;

import com.example.todosapi.data.entity.ToDo;
import com.example.todosapi.data.dto.ToDoDTO;

public class ToDoMapper {

    public ToDo mapToDoDtoToEntity(ToDoDTO toDoDTO){
        ToDo toDoEntity = new ToDo();
        toDoEntity.setId(toDoDTO.getId());
        toDoEntity.setTitle(toDoEntity.getTitle());
        toDoEntity.setDescription(toDoEntity.getDescription());
        toDoEntity.setCompleted(toDoDTO.isCompleted());
        toDoEntity.setCreatedAt(toDoDTO.getCreatedAt());
        toDoEntity.setUpdatedAt(toDoDTO.getUpdatedAt());
        return toDoEntity;
    }

    public ToDoDTO mapEntityToDoDto(ToDo toDo){
        ToDoDTO toDoDTO = new ToDoDTO();
        toDoDTO.setId(toDo.getId());
        toDoDTO.setTitle(toDo.getTitle());
        toDoDTO.setCompleted(toDo.isCompleted());
        toDoDTO.setCreatedAt(toDo.getCreatedAt());
        toDoDTO.setUpdatedAt(toDo.getUpdatedAt());
        return toDoDTO;
    }
}
