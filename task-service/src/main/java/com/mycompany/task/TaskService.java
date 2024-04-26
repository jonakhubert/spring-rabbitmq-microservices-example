package com.mycompany.task;

import org.springframework.data.domain.Page;

import java.util.List;

public interface TaskService {
    List<TaskDTO> getAllTasks();
    TaskDTO getTask(int id);
    void saveTask(Task task);
    void deleteTask(int id);
    Page<TaskDTO> getTasksPage(int pageSize, int pageNumber, String sortField, String sortDirection);
}
