package com.GridFlow.GridFlow;

import com.GridFlow.GridFlow.processing.processor.Processor;
import com.GridFlow.GridFlow.processing.processor.impl.FilteringProcessor;
import com.GridFlow.GridFlow.processing.processor.impl.TransformationProcessor;
import com.GridFlow.GridFlow.receiver.processor.EnrichProcessorReceiver;
import com.GridFlow.GridFlow.sender.processor.DataStoringProcessorSender;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ProcessorRegistry {

    private final Map<String, Processor> processors = new HashMap<>();

    public ProcessorRegistry(FilteringProcessor loggingProcessor, TransformationProcessor transformProcessor,
                             EnrichProcessorReceiver enrichProcessor, DataStoringProcessorSender dataStoringProcessor) {
        processors.put("logging", loggingProcessor);
        processors.put("transform", transformProcessor);
        processors.put("enrich", enrichProcessor);
        processors.put("datastoring", dataStoringProcessor);
    }

    public Processor getProcessor(String name) {
        return processors.get(name);
    }

}
