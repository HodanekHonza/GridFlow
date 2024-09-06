package com.GridFlow.GridFlow.receiver.route;

import com.GridFlow.GridFlow.ProcessorRegistry;
import com.GridFlow.GridFlow.processing.processor.Processor;
import com.GridFlow.GridFlow.receiver.route.Route;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RouteBuilder {

    private final ProcessorRegistry processorRegistry;

    public RouteBuilder(ProcessorRegistry processorRegistry) {
        this.processorRegistry = processorRegistry;
    }

    public <T extends Route> T buildRoute(T route, String processorNames) {
        List<String> chosenProcessors = Arrays.asList(processorNames.split(","));

        chosenProcessors.forEach(processorName -> {
            Processor processor = processorRegistry.getProcessor(processorName);
            if (processor != null) {
                route.addProcessor(processor);
            }
        });

        return route;
    }
}
