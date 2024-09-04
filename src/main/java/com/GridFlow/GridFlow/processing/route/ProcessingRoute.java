package com.GridFlow.GridFlow.processing.route;


import com.GridFlow.GridFlow.processing.processor.Processor;
import com.GridFlow.GridFlow.receiver.api.dto.Message;
import com.GridFlow.GridFlow.sender.route.SenderRoute;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProcessingRoute {
    private final List<Processor> processors = new ArrayList<>();
    private SenderRoute nextRoute;

    public ProcessingRoute addProcessor(Processor processor) {
        this.processors.add(processor);
        return this;
    }

    public void setNextRoute(SenderRoute nextRoute) {
        this.nextRoute = nextRoute;
    }

    public void execute(Message message) {
        for (Processor processor : processors) {
            processor.process(message);
        }
        if (nextRoute != null) {
            nextRoute.execute(message);
        }
    }
}
