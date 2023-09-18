package com.demo.spring.consumer.amqp.implementation;

import com.demo.spring.consumer.amqp.AmqpConsumer;
import com.demo.spring.consumer.dto.MessageQueueDTO;
import com.demo.spring.consumer.service.ConsumerService;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsumerRabbitMQImpl implements AmqpConsumer<MessageQueueDTO> {

    @Autowired
    private ConsumerService consumerService;

    @Override
    @RabbitListener(queues = "${spring.rabbitmq.routing-key.producer}")
    public void consumer(MessageQueueDTO message) {
        try {
            consumerService.action(message);
        } catch (Exception ex) {
            throw new AmqpRejectAndDontRequeueException(ex);
        }
    }


}
