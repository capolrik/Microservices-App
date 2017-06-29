package com.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskProducer
{
    @Autowired
    private TaskProducerConfiguration taskProducerConfiguration;

    public void run(String taskMessage) throws Exception {
        System.out.println("Sending message..."); 
    taskProducerConfiguration.rabbitTemplate()
                .convertAndSend(taskProducerConfiguration.tasksQueue, taskMessage);
    System.out.println("--- Message sent ---");

    }

}