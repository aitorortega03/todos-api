package com.example.todosapi.service;

import com.example.todosapi.dao.ToDoDao;
import com.example.todosapi.data.dto.ToDoDTO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class ToDoServiceTest {

    @InjectMocks
    private ToDoService toDoService;

    @Mock
    private ToDoDao toDoDao;
    @Test
    void searchAllToDosTest() {
        List<ToDoDTO> toDoDTOList = new ArrayList<>();
        toDoDTOList.add(new ToDoDTO(1L, "First ToDo", "This is the first ToDo", false, LocalDateTime.now(), LocalDateTime.now()));
        toDoDTOList.add(new ToDoDTO(2L, "Second ToDo", "This is the second ToDo", true, LocalDateTime.now(), LocalDateTime.now()));

        when(toDoDao.getAllToDos()).thenReturn(toDoDTOList);


        // Act
        List<ToDoDTO> toDos = toDoService.searchAllToDos();

        // Assert
        assertEquals(2, toDos.size());
        assertEquals("First ToDo", toDos.get(0).getTitle());
        assertEquals("This is the second ToDo", toDos.get(1).getDescription());
        assertFalse(toDos.get(0).isCompleted());

    }

    @Test
    void searchToDoByIdTest() {
        ToDoDTO toDoDTO = new ToDoDTO(1L, "ToDo title", "This is a ToDo", false, LocalDateTime.now(), LocalDateTime.now());

        when(toDoDao.getToDoById(1L)).thenReturn(Optional.of(toDoDTO));

        //Act
        Optional<ToDoDTO> toDoOptional = toDoService.searchToDoById(1L);

        //Assert
        assertTrue(toDoOptional.isPresent());
        assertEquals("ToDo title", toDoOptional.get().getTitle());
        assertEquals("This is a ToDo", toDoOptional.get().getDescription());
        assertFalse(toDoOptional.get().isCompleted());
    }

    @Test
    void saveNewToDoTest() {
        ToDoDTO toDoDTO = new ToDoDTO(1L, "ToDo title", "This is a ToDo", false, LocalDateTime.now(), LocalDateTime.now());

        when(toDoDao.getToDoById(1L)).thenReturn(Optional.of(toDoDTO));

        //Act
        toDoService.saveNewToDo(toDoDTO);

        Optional<ToDoDTO> toDoOptional = toDoService.searchToDoById(1L);

        //Assert
        assertTrue(toDoOptional.isPresent());
        assertEquals("ToDo title", toDoOptional.get().getTitle());
        assertEquals("This is a ToDo", toDoOptional.get().getDescription());
        assertFalse(toDoOptional.get().isCompleted());

    }

    @Test
    void updateToDoTest() {
        ToDoDTO toDoDTO = new ToDoDTO(1L, "ToDo title", "This is a ToDo", false, LocalDateTime.now(), LocalDateTime.now());

        when(toDoDao.getToDoById(1L)).thenReturn(Optional.of(toDoDTO));

        //Act
        toDoService.saveNewToDo(toDoDTO);
        toDoDTO.setTitle("ToDo title");
        toDoService.updateToDo(toDoDTO.getId(), toDoDTO);

        Optional<ToDoDTO> toDoOptional = toDoService.searchToDoById(1L);

        //Assert
        assertTrue(toDoOptional.isPresent());
        assertEquals("ToDo title", toDoOptional.get().getTitle());
    }

    @Test
    void deleteToDoByIdTest() {
        ToDoDTO toDoDTO = new ToDoDTO(1L, "ToDo title", "This is a ToDo", false, LocalDateTime.now(), LocalDateTime.now());

        when(toDoDao.getToDoById(1L)).thenReturn(Optional.of(toDoDTO));

        //Act
        toDoService.saveNewToDo(toDoDTO);

        ToDoDTO toDoDTODeleted = toDoService.deleteToDoById(1L);

        //Assert
        assertNotNull(toDoDTODeleted);
    }
}