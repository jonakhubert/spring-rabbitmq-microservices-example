package com.mycompany.task;

import java.sql.Timestamp;

public record TaskDTO(
    int id,
    String title,
    String description,
    String notes,
    String assignee,
    Timestamp startDate,
    TaskStatus status,
    PriorityType priority
) {}
