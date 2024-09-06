package com.GridFlow.GridFlow.receiver.route;

import com.GridFlow.GridFlow.processing.processor.Processor;
import com.GridFlow.GridFlow.receiver.api.dto.Message;

import java.util.ArrayList;
import java.util.List;

public class ReceiverRoute implements Route {
    private final List<Processor> processors = new ArrayList<>();
    private Route nextRoute;

    @Override
    public ReceiverRoute addProcessor(Processor processor) {
        this.processors.add(processor);
        return this;
    }

    @Override
    public void setNextRoute(Route nextRoute) {
        this.nextRoute = nextRoute;
    }

    @Override
    public void execute(Message message) {
        for (Processor processor : processors) {
            processor.process(message);
        }
        if (nextRoute != null) {
            nextRoute.execute(message);
        }
    }
}
