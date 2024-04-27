package com.mycompany.task;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tasks")
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "notes")
    private String notes;

    @Column(name = "assignee")
    private String assignee;

    @Column(name = "start_date")
    private Timestamp startDate;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private TaskStatus status;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "priority")
    private PriorityType priority;

    @CreatedDate
    @Column(name = "created_date")
    private Timestamp createdDate;

    @Column(name = "updated_date")
    private Timestamp updatedDate;

    public Task() {}

    public Task(int id, String title, String description, String notes, String assignee, Timestamp startDate,
            TaskStatus status, PriorityType priority, Timestamp createdDate, Timestamp updatedDate
    ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.notes = notes;
        this.assignee = assignee;
        this.startDate = startDate;
        this.status = status;
        this.priority = priority;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    // getters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getNotes() { return notes; }
    public String getAssignee() { return assignee; }
    public Timestamp getStartDate() { return startDate; }
    public TaskStatus getStatus() { return status; }
    public PriorityType getPriority() { return priority; }
    public Timestamp getCreatedDate() { return createdDate; }
    public Timestamp getUpdatedDate() { return updatedDate; }

    // setters
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setNotes(String notes) { this.notes = notes; }
    public void setAssignee(String assignee) { this.assignee = assignee; }
    public void setStartDate(Timestamp startDate) { this.startDate = startDate; }
    public void setStatus(TaskStatus status) { this.status = status; }
    public void setPriority(PriorityType priority) { this.priority = priority; }
    public void setCreatedDate(Timestamp createdDate) { this.createdDate = createdDate; }
    public void setUpdatedDate(Timestamp updatedDate) { this.updatedDate = updatedDate; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task other)) return false;

        return Objects.equals(id, other.id) &&
               Objects.equals(title, other.title) &&
               Objects.equals(description, other.description) &&
               Objects.equals(notes, other.notes) &&
               Objects.equals(assignee, other.assignee) &&
               Objects.equals(startDate, other.startDate) &&
               status == other.status && priority == other.priority &&
               Objects.equals(createdDate, other.createdDate) &&
               Objects.equals(updatedDate, other.updatedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, notes, assignee, startDate, status, priority, createdDate,
            updatedDate);
    }
}
