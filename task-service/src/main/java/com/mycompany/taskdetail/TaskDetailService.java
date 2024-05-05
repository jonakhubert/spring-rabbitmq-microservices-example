package com.mycompany.taskdetail;

import java.util.List;

public interface TaskDetailService {
    void saveTaskDetail(TaskDetail taskDetail);
    void deleteTaskDetail(String id);
    TaskDetail getTaskDetail(String id);
    List<TaskDetail> getAllTaskDetails();
    List<TaskDetail> getTaskDetailsWithDescription(String description);
}
