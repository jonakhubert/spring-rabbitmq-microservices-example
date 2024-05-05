package com.mycompany.notification;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "task_id")
    private String taskId;

    @Column(name = "employee_id")
    private String employeeId;

    @Column(name = "task_title")
    private String taskTitle;

    @Column(name = "task_description")
    private String taskDescription;

    public Notification() {}

    public Notification(int id, String taskId, String employeeId, String taskTitle, String taskDescription) {
        this.id = id;
        this.taskId = taskId;
        this.employeeId = employeeId;
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
    }

    // getters
    public int getId() { return id; }
    public String getTaskId() { return taskId; }
    public String getEmployeeId() { return employeeId; }
    public String getTaskTitle() { return taskTitle; }
    public String getTaskDescription() { return taskDescription; }

    // setters
    public void setId(int id) { this.id = id; }
    public void setTaskId(String taskId) { this.taskId = taskId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public void setTaskTitle(String taskTitle) { this.taskTitle = taskTitle; }
    public void setTaskDescription(String taskDescription) { this.taskDescription = taskDescription; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Notification other)) return false;

        return id == other.id &&
               Objects.equals(taskId, other.taskId) &&
               Objects.equals(employeeId, other.employeeId) &&
               Objects.equals(taskTitle, other.taskTitle) &&
               Objects.equals(taskDescription, other.taskDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taskId, employeeId, taskTitle, taskDescription);
    }
}
