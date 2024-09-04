package com.GridFlow.GridFlow.sender.route;

import com.GridFlow.GridFlow.processing.processor.Processor;
import com.GridFlow.GridFlow.receiver.api.dto.Message;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SenderRoute {
    private final List<Processor> processors = new ArrayList<>();

    public SenderRoute addProcessor(Processor processor) {
        this.processors.add(processor);
        return this;
    }

    public void execute(Message message) {
        for (Processor processor : processors) {
            processor.process(message);
        }
        // Implement sending logic here (e.g., send the message to an external system or service)
        sendToExternalSystem(message);
    }

    private void sendToExternalSystem(Message message) {
        // Example implementation: print to console or send to an external system
        System.out.println("Sending message: " + message);
    }
}
