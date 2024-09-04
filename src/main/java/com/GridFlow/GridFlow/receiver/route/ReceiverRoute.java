package com.GridFlow.GridFlow.receiver.route;


import com.GridFlow.GridFlow.processing.processor.Processor;
import com.GridFlow.GridFlow.processing.route.ProcessingRoute;
import com.GridFlow.GridFlow.receiver.api.dto.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReceiverRoute {
    private final List<Processor> processors = new ArrayList<>();
    private ProcessingRoute nextRoute;

    public ReceiverRoute addProcessor(Processor processor) {
        this.processors.add(processor);
        return this;
    }

    public void setNextRoute(ProcessingRoute nextRoute) {
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


