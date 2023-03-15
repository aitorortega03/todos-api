package com.example.todosapi.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ToDoServiceTest {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ToDoService toDoService;
    @Test
    void searchAllToDosTest() {
    }

    @Test
    void searchToDoByIdTest() {
    }

    @Test
    void saveNewToDoTest() {
    }

    @Test
    void updateToDoTest() {
    }

    @Test
    void deleteToDoByIdTest() {
    }
}