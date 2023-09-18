package com.demo.spring.consumer.service.implementation;

import com.demo.spring.consumer.dto.MessageQueueDTO;
import com.demo.spring.consumer.service.ConsumerService;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Override
    public void action(MessageQueueDTO message) throws Exception {
        if(message.getIsError()) {
            throw new Exception("Simulando processamento com erro.");
        }
        System.out.println(message.getText());
    }

}
