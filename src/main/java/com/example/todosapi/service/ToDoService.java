package com.example.todosapi.service;

import com.example.todosapi.dao.ToDoDao;
import com.example.todosapi.data.dto.ToDoDTO;
import com.example.todosapi.service.interfaces.IToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService implements IToDoService {

    @Autowired
    private ToDoDao toDoDao;

    @Override
    public List<ToDoDTO> searchAllToDos() {
        return toDoDao.getAllToDos();
    }

    @Override
    public Optional<ToDoDTO> searchToDoById(Long id) {
        return toDoDao.getToDoById(id);
    }

    @Override
    public void saveNewToDo(ToDoDTO newToDo) {
        toDoDao.saveToDo(newToDo);
    }

    @Override
    public ToDoDTO updateToDo(Long id, ToDoDTO toDoUpdated) {
        Optional<ToDoDTO> toDoOptional = toDoDao.getToDoById(id);
        if (toDoOptional.isPresent()) {
            ToDoDTO toDo = toDoOptional.get();
            if (toDo.getTitle() != null){
                toDo.setTitle(toDoUpdated.getTitle());
            }
            if (toDo.getDescription() != null){
                toDo.setDescription(toDoUpdated.getDescription());
            }
            toDo.setCompleted(toDoUpdated.isCompleted());
            toDoDao.saveToDo(toDo);
            return toDo;
        }
        return null;
    }

    @Override
    public ToDoDTO deleteToDoById(Long id) {
        Optional<ToDoDTO> toDo = toDoDao.getToDoById(id);
        if (toDo.isPresent()) {
            toDoDao.deleteToDoById(id);
            return toDo.get();
        }
        return null;
    }
}
