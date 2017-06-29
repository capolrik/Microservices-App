package com.backend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;



@Configuration
public class TaskProducerConfiguration extends RabbitMqConfiguration
{
    protected final String tasksQueue = "tasks.queue";

    @Bean
    public RabbitTemplate rabbitTemplate()
    {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        template.setRoutingKey(this.tasksQueue);
        template.setQueue(this.tasksQueue);
        template.setMessageConverter(jsonMessageConverter());
        return template;
    }

    @Bean
    public Queue tasksQueue()
    {
        return new Queue(this.tasksQueue);
    }
}
