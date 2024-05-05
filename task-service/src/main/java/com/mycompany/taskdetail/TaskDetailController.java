package com.mycompany.taskdetail;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/task-details")
public class TaskDetailController {

    private final TaskDetailService taskDetailService;

    public TaskDetailController(TaskDetailService taskDetailService) {
        this.taskDetailService = taskDetailService;
    }

    @PostMapping
    public ResponseEntity<Void> addTaskDetail(@RequestBody TaskDetail taskDetail) {
        taskDetailService.saveTaskDetail(taskDetail);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<TaskDetail> getTaskDetail(@PathVariable("id") String id) {
        return ResponseEntity.ok(taskDetailService.getTaskDetail(id));
    }

    @GetMapping
    public ResponseEntity<List<TaskDetail>> getTaskDetails() {
        return ResponseEntity.ok(taskDetailService.getAllTaskDetails());
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> deleteTaskDetail(@PathVariable("id") String id) {
        taskDetailService.deleteTaskDetail(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
