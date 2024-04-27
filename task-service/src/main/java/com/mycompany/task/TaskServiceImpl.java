package com.mycompany.task;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskDTOMapper taskDTOMapper;

    public TaskServiceImpl(TaskRepository taskRepository, TaskDTOMapper taskDTOMapper) {
        this.taskRepository = taskRepository;
        this.taskDTOMapper = taskDTOMapper;
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        return taskRepository.findAll().stream().map(taskDTOMapper).collect(Collectors.toList());
    }

    @Override
    public TaskDTO getTask(int id) {
        return taskRepository.findById(id).map(taskDTOMapper)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    @Override
    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Page<TaskDTO> getTasksPage(int pageSize, int pageNumber, String sortField, String sortDirection) {
        return null;
    }
}
