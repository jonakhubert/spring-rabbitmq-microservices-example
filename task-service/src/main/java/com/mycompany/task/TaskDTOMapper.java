package com.mycompany.task;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TaskDTOMapper implements Function<Task, TaskDTO> {

    @Override
    public TaskDTO apply(Task task) {
        return new TaskDTO(task.getId(), task.getTitle(), task.getDescription(), task.getNotes(), task.getAssignee(),
            task.getStartDate(), task.getStatus(), task.getPriority());
    }
}
