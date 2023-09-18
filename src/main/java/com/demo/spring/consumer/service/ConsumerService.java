package com.demo.spring.consumer.service;

import com.demo.spring.consumer.dto.MessageQueueDTO;

public interface ConsumerService {

    void action(MessageQueueDTO message) throws Exception;
}
