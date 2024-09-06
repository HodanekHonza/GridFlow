package com.GridFlow.GridFlow.receiver.processor;

import com.GridFlow.GridFlow.processing.processor.Processor;
import com.GridFlow.GridFlow.receiver.api.dto.Message;
import org.springframework.stereotype.Service;

@Service
public class EnrichProcessorReceiver implements Processor {
    @Override
    public void process(Message message) {
        System.out.println("IN ENRICH PROCESSOR");
        String transformedBody = message.getBody().toUpperCase();
        message.setBody(transformedBody);
    }
}

