package com.mycompany.task;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Void> addTask(@RequestBody Task task) {
        taskService.saveTask(task);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<TaskDTO> getTask(@PathVariable("id") int id) {
        return ResponseEntity.ok(taskService.getTask(id));
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable("id") int id) {
        taskService.deleteTask(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
