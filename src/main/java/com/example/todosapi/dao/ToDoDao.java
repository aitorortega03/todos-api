package com.example.todosapi.dao;

import com.example.todosapi.data.entity.ToDo;
import com.example.todosapi.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ToDoDao {


    private final ToDoRepository toDoRepository;

    @Autowired
    public ToDoDao(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<ToDo> getAllToDos() {
        return toDoRepository.findAll();
    }

    public Optional<ToDo> getToDoById(Long id) {
        return toDoRepository.findById(id);
    }

    public void saveToDo(ToDo toDo){
        toDoRepository.save(toDo);
    }

    public void deleteToDoById(Long id) {
        toDoRepository.deleteById(id);
    }


}
