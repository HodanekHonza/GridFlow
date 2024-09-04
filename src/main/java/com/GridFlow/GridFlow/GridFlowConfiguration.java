package com.GridFlow.GridFlow;

import com.GridFlow.GridFlow.processing.processor.impl.LoggingProcessor;
import com.GridFlow.GridFlow.processing.processor.impl.TransformProcessor;
import com.GridFlow.GridFlow.receiver.processor.EnrichProcessor;
import com.GridFlow.GridFlow.receiver.route.ReceiverRoute;
import com.GridFlow.GridFlow.processing.route.ProcessingRoute;
import com.GridFlow.GridFlow.sender.processor.DataStoringProcessor;
import com.GridFlow.GridFlow.sender.route.SenderRoute;
import com.GridFlow.GridFlow.receiver.api.ReceiverController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GridFlowConfiguration {

    @Bean
    public ReceiverRoute receiverRoute(LoggingProcessor loggingProcessor, TransformProcessor transformProcessor) {
        return new ReceiverRoute()
                .addProcessor(loggingProcessor)
                .addProcessor(transformProcessor);
    }

    @Bean
    public ProcessingRoute processingRoute(EnrichProcessor enrichProcessor) {
        return new ProcessingRoute()
                .addProcessor(enrichProcessor);
    }

    @Bean
    public SenderRoute senderRoute(DataStoringProcessor dataStoringProcessor) {
        return new SenderRoute()
                .addProcessor(dataStoringProcessor);
    }

    @Bean
    public ReceiverController receiverController(ReceiverRoute receiverRoute, ProcessingRoute processingRoute, SenderRoute senderRoute) {
        // Connect ReceiverRoute to ProcessingRoute, and ProcessingRoute to SenderRoute
        receiverRoute.setNextRoute(processingRoute);
        processingRoute.setNextRoute(senderRoute);
        return new ReceiverController(receiverRoute);
    }
}

