package com.mycompany.task;

import java.io.Serializable;

public record TaskNotificationDTO(
        String taskId,
        String employeeId,
        String taskTitle,
        String taskDescription
) implements Serializable {}
