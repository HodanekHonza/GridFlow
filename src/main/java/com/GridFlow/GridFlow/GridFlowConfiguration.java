package com.GridFlow.GridFlow;


import com.GridFlow.GridFlow.processing.processor.impl.LoggingProcessor;
import com.GridFlow.GridFlow.processing.processor.impl.TransformProcessor;
import com.GridFlow.GridFlow.receiver.route.ReceiverRoute;
import com.GridFlow.GridFlow.processing.route.ProcessingRoute;
import com.GridFlow.GridFlow.sender.route.SenderRoute;
import com.GridFlow.GridFlow.receiver.api.ReceiverController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GridFlowConfiguration {

    @Bean
    public ReceiverRoute receiverRoute(LoggingProcessor loggingProcessor) {
        return new ReceiverRoute()
                .addProcessor(loggingProcessor);
    }

    @Bean
    public ProcessingRoute processingRoute(TransformProcessor transformProcessor) {
        return new ProcessingRoute()
                .addProcessor(transformProcessor);
    }

    @Bean
    public SenderRoute senderRoute() {
        return new SenderRoute();
    }

    @Bean
    public ReceiverController receiverController(ReceiverRoute receiverRoute, ProcessingRoute processingRoute, SenderRoute senderRoute) {
        // Connect ReceiverRoute to ProcessingRoute, and ProcessingRoute to SenderRoute
        receiverRoute.setNextRoute(processingRoute);
        processingRoute.setNextRoute(senderRoute);
        return new ReceiverController(receiverRoute);
    }
}

