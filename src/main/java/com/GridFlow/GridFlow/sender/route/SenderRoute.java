package com.GridFlow.GridFlow.sender.route;

import com.GridFlow.GridFlow.processing.processor.Processor;
import com.GridFlow.GridFlow.receiver.api.dto.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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
        sendToExternalSystem(message);
    }

    private void sendToExternalSystem(Message message) {
        System.out.println("Sending message: " + message.getBody());
    }
}
