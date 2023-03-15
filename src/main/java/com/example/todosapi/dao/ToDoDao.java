package com.example.todosapi.dao;

import com.example.todosapi.data.dto.ToDoDTO;
import com.example.todosapi.data.entity.ToDo;
import com.example.todosapi.data.mapper.ToDoMapper;
import com.example.todosapi.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ToDoDao {


    private final ToDoRepository toDoRepository;
    private final ToDoMapper toDoMapper = new ToDoMapper();

    @Autowired
    public ToDoDao(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<ToDoDTO> getAllToDos() {
        return toDoRepository.findAll().stream()
                .map(toDoMapper::mapEntityToDoDto)
                .toList();
    }

    public Optional<ToDoDTO> getToDoById(Long id) {
        return toDoRepository.findById(id).map(toDoMapper::mapEntityToDoDto);
    }

    public void saveToDo(ToDoDTO toDo){
        ToDo entity = toDoMapper.mapToDoDtoToEntity(toDo);
        toDoRepository.save(entity);
    }

    public void deleteToDoById(Long id) {
        toDoRepository.deleteById(id);
    }


}
