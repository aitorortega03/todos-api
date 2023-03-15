package com.example.todosapi.dao;

import com.example.todosapi.data.dto.ToDoDTO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
class ToDoDaoTest {

    @Autowired
    private ToDoDao toDoDao;

    @Test
    void getAllToDosTest() {
        //given
        ToDoDTO toDoDTO = new ToDoDTO();
        toDoDTO.setTitle("Prueba");
        toDoDTO.setDescription("Prueba");
        toDoDTO.setCompleted(false);
        toDoDao.saveToDo(toDoDTO);

        //when
        List<ToDoDTO> toDos = toDoDao.getAllToDos();

        //then
        assertTrue(toDos.size() >= 1);
    }

    @Test
    void getToDoByIdTest() {
        //given
        ToDoDTO toDoDTO = new ToDoDTO();
        toDoDTO.setTitle("Prueba");
        toDoDTO.setDescription("Prueba");
        toDoDTO.setCompleted(false);
        toDoDao.saveToDo(toDoDTO);

        List<ToDoDTO> toDos = toDoDao.getAllToDos();
        Long lastToDoIdSaved = toDos.get(toDos.size() - 1).getId();

        //when

        Optional<ToDoDTO> toDo = toDoDao.getToDoById(lastToDoIdSaved);

        //then
        assertTrue(toDo.isPresent());
    }

    @Test
    void saveToDoTest() {
        //given
        ToDoDTO toDoDTO = new ToDoDTO();
        toDoDTO.setTitle("Prueba");
        toDoDTO.setDescription("Prueba");
        toDoDTO.setCompleted(false);
        toDoDao.saveToDo(toDoDTO);

        //when
        List<ToDoDTO> toDos = toDoDao.getAllToDos();

        //then
        assertTrue(toDos.size() >= 1);
    }

    @Test
    void deleteToDoByIdTest() {
        //given
        ToDoDTO toDoDTO = new ToDoDTO();
        toDoDTO.setTitle("Prueba");
        toDoDTO.setDescription("Prueba");
        toDoDTO.setCompleted(false);
        toDoDao.saveToDo(toDoDTO);

        List<ToDoDTO> toDos = toDoDao.getAllToDos();
        Long lastToDoIdSaved = toDos.get(toDos.size() - 1).getId();

        //when
        toDoDao.deleteToDoById(lastToDoIdSaved);
        Optional<ToDoDTO> toDo = toDoDao.getToDoById(lastToDoIdSaved);

        //then
        assertFalse(toDo.isPresent());
    }
}