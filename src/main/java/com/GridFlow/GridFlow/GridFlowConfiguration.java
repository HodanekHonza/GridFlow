package com.GridFlow.GridFlow;

import com.GridFlow.GridFlow.receiver.route.ReceiverRoute;
import com.GridFlow.GridFlow.processing.route.ProcessingRoute;
import com.GridFlow.GridFlow.receiver.route.RouteBuilder;
import com.GridFlow.GridFlow.sender.route.SenderRoute;
import com.GridFlow.GridFlow.receiver.api.ReceiverController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GridFlowConfiguration {

    @Value("${receiver.processors.choosen}")
    private String receiverProcessorsChoosen;

    @Value("${processing.processors.choosen}")
    private String processingProcessorsChoosen;

    @Value("${sender.processors.choosen}")
    private String senderProcessorsChoosen;

    private final ProcessorRegistry processorRegistry;
    private final RouteBuilder routeBuilder;

    public GridFlowConfiguration(ProcessorRegistry processorRegistry, RouteBuilder routeBuilder) {
        this.processorRegistry = processorRegistry;
        this.routeBuilder = routeBuilder;
    }

    @Bean
    public ReceiverRoute receiverRoute() {
        return routeBuilder.buildRoute(new ReceiverRoute(), receiverProcessorsChoosen);
    }

    @Bean
    public ProcessingRoute processingRoute() {
        return routeBuilder.buildRoute(new ProcessingRoute(), processingProcessorsChoosen);
    }

    @Bean
    public SenderRoute senderRoute() {
        return routeBuilder.buildRoute(new SenderRoute(), senderProcessorsChoosen);
    }

    @Bean
    public ReceiverController receiverController(ReceiverRoute receiverRoute, ProcessingRoute processingRoute, SenderRoute senderRoute) {
        // Connect ReceiverRoute to ProcessingRoute, and ProcessingRoute to SenderRoute
        receiverRoute.setNextRoute(processingRoute);
        processingRoute.setNextRoute(senderRoute);
        return new ReceiverController(receiverRoute);
    }
}
