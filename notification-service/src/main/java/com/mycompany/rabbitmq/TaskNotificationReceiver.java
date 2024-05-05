package com.mycompany.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.task.TaskNotificationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "${spring.rabbitmq.queue}", id = "listener")
public class TaskNotificationReceiver {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Logger logger = LoggerFactory.getLogger(TaskNotificationReceiver.class);

    @RabbitHandler
    public void receive(String message) throws JsonProcessingException {
        var taskNotificationDTO = objectMapper.readValue(message, TaskNotificationDTO.class);
        logger.info("Message received from Task Service: {}", taskNotificationDTO.toString());
    }
}
