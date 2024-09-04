package com.GridFlow.GridFlow.processing.processor.impl;

import com.GridFlow.GridFlow.processing.processor.Processor;
import com.GridFlow.GridFlow.receiver.api.dto.Message;
import org.springframework.stereotype.Component;

@Component
public class LoggingProcessor implements Processor {
    @Override
    public void process(Message message) {
        System.out.println("Received message: " + message.getBody());
    }
}
