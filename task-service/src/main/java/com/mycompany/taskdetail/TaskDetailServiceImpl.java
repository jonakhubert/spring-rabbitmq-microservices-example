package com.mycompany.taskdetail;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskDetailServiceImpl implements TaskDetailService {

    private final TaskDetailRepository taskDetailRepository;

    public TaskDetailServiceImpl(TaskDetailRepository taskDetailRepository) {
        this.taskDetailRepository = taskDetailRepository;
    }

    @Override
    public void saveTaskDetail(TaskDetail taskDetail) {
        taskDetailRepository.save(taskDetail);
    }

    @Override
    public void deleteTaskDetail(String id) {
        taskDetailRepository.deleteById(id);
    }

    @Override
    public TaskDetail getTaskDetail(String id) {
        return taskDetailRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Task detail not found"));
    }

    @Override
    public List<TaskDetail> getAllTaskDetails() {
        var taskDetails = new ArrayList<TaskDetail>();
        taskDetailRepository.findAll().forEach(taskDetails::add);
        return taskDetails;
    }

    @Override
    public List<TaskDetail> getTaskDetailsWithDescription(String description) {
        return taskDetailRepository.findByTaskDescriptionContains(description);
    }
}
