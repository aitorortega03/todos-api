package com.example.todosapi.service;

import com.example.todosapi.dao.ToDoDao;
import com.example.todosapi.data.entity.ToDo;
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
    public List<ToDo> searchAllToDos() {
        return toDoDao.getAllToDos();
    }

    @Override
    public Optional<ToDo> searchToDoById(Long id) {
        return toDoDao.getToDoById(id);
    }

    @Override
    public ToDo saveNewToDo(ToDo newToDo) {
        toDoDao.saveToDo(newToDo);
        return newToDo;
    }

    @Override
    public ToDo updateToDo(Long id, ToDo toDoUpdated) {
        Optional<ToDo> toDoOptional = toDoDao.getToDoById(id);
        if (toDoOptional.isPresent()) {
            ToDo toDo = toDoOptional.get();
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
    public ToDo deleteToDoById(Long id) {
        Optional<ToDo> toDo = toDoDao.getToDoById(id);
        if (toDo.isPresent()) {
            toDoDao.deleteToDoById(id);
            return toDo.get();
        }
        return null;
    }
}
