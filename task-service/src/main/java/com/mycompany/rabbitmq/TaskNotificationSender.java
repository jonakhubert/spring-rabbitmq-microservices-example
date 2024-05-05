package com.mycompany.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.task.TaskNotificationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TaskNotificationSender {

    @Value("${spring.rabbitmq.exchange}")
    private String exchangeName;

    @Value("${spring.rabbitmq.routingKey}")
    private String routingKey;

    private final AmqpTemplate amqpTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Logger logger = LoggerFactory.getLogger(TaskNotificationSender.class);


    public TaskNotificationSender(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void sendToQueue(TaskNotificationDTO taskNotificationDTO) throws JsonProcessingException {
        var task = objectMapper.writeValueAsString(taskNotificationDTO);
        logger.info("Notification sent: {}", taskNotificationDTO.toString());
        amqpTemplate.convertAndSend(exchangeName, routingKey, task);
    }
}
