package com.GridFlow.GridFlow.processing.processor.impl;

import com.GridFlow.GridFlow.processing.processor.Processor;
import com.GridFlow.GridFlow.receiver.api.dto.Message;
import org.springframework.stereotype.Component;

@Component
public class TransformProcessor implements Processor {
    @Override
    public void process(Message message) {
        String transformedBody = message.getBody().toUpperCase();
        message.setBody(transformedBody);
    }
}

