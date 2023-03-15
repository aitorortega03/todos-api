package com.example.todosapi.controller;

import com.example.todosapi.data.entity.ToDo;
import com.example.todosapi.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/api/v1/todos")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @GetMapping("/")
    public ResponseEntity<List<ToDo>> getAllToDos() {
        return ResponseEntity.ok(toDoService.searchAllToDos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDo> getToDoById(@PathVariable("id") Long id) {
        Optional<ToDo> toDo = toDoService.searchToDoById(id);
        return toDo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<ToDo> addToDo(@RequestBody ToDo toDo) {
        toDoService.saveNewToDo(toDo);
        URI location = fromCurrentRequest().path("/{id}")
                .buildAndExpand(toDo.getId()).toUri();
        return ResponseEntity.created(location).body(toDo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDo> updateToDo(@PathVariable("id") Long id, @RequestBody ToDo newToDo) {
        ToDo toDoForDelete = toDoService.updateToDo(id, newToDo);
        if (toDoForDelete == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(toDoForDelete);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ToDo> deleteToDo(@PathVariable("id") Long id) {
        ToDo toDoForDelete = toDoService.deleteToDoById(id);
        if (toDoForDelete == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(toDoForDelete);
    }
}
