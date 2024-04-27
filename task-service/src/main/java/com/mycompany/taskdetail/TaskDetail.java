package com.mycompany.taskdetail;

import com.mycompany.task.PriorityType;
import com.mycompany.task.TaskStatus;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Objects;

@Document(indexName = "task-detail")
public class TaskDetail implements Serializable {

    @Id
    private String id;
    private int employeeId;
    private String employeeFirstName;
    private String employeeLastName;
    private String taskTitle;
    private String taskDescription;
    private TaskStatus taskStatus;
    private PriorityType taskPriority;

    public TaskDetail() {}

    public TaskDetail(String id, int employeeId, String employeeFirstName, String employeeLastName, String taskTitle,
                      String taskDescription, TaskStatus taskStatus, PriorityType taskPriority
    ) {
        this.id = id;
        this.employeeId = employeeId;
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.taskStatus = taskStatus;
        this.taskPriority = taskPriority;
    }

    // getters
    public String getId() { return id; }
    public int getEmployeeId() { return employeeId; }
    public String getEmployeeFirstName() { return employeeFirstName; }
    public String getEmployeeLastName() { return employeeLastName; }
    public String getTaskTitle() { return taskTitle; }
    public String getTaskDescription() { return taskDescription; }
    public TaskStatus getTaskStatus() { return taskStatus; }
    public PriorityType getTaskPriority() { return taskPriority; }

    // setters
    public void setId(String id) { this.id = id; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }
    public void setEmployeeFirstName(String employeeFirstName) { this.employeeFirstName = employeeFirstName; }
    public void setEmployeeLastName(String employeeLastName) { this.employeeLastName = employeeLastName; }
    public void setTaskTitle(String taskTitle) { this.taskTitle = taskTitle; }
    public void setTaskDescription(String taskDescription) { this.taskDescription = taskDescription; }
    public void setTaskStatus(TaskStatus taskStatus) { this.taskStatus = taskStatus; }
    public void setTaskPriority(PriorityType taskPriority) { this.taskPriority = taskPriority; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaskDetail other)) return false;

        return Objects.equals(id, other.id) &&
                Objects.equals(employeeId, other.employeeId) &&
                Objects.equals(employeeFirstName, other.employeeFirstName) &&
                Objects.equals(employeeLastName, other.employeeLastName) &&
                Objects.equals(taskTitle, other.taskTitle) &&
                Objects.equals(taskDescription, other.taskDescription) &&
                taskStatus == other.taskStatus && taskPriority == other.taskPriority;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employeeId, employeeFirstName, employeeLastName, taskTitle, taskDescription, taskStatus,
                taskPriority);
    }
}
