package com.backend;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;

import com.rabbitmq.client.AMQP.Queue;

public class ConsumerConfiguration extends RabbitMqConfiguration{
	
    protected final String ConsumerQueue = "consumef.queue";
    //TODO find the message to read
    private String message;
    
  

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        template.setRoutingKey(this.ConsumerQueue);
        template.setQueue(this.ConsumerQueue);
        template.setMessageConverter(jsonMessageConverter());
        return template;
    }

    @Bean
    public Queue ConsumerQueue() {
        return new Queue();
    }

    @Bean
    public SimpleMessageListenerContainer listenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setQueueNames(this.ConsumerQueue);
        container.setMessageListener(messageListenerAdapter());
        return container;
    }

    @Bean
    public MessageListenerAdapter messageListenerAdapter() {
        return new MessageListenerAdapter(message, jsonMessageConverter());
    }
}