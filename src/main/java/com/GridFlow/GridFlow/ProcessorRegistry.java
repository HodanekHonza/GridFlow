package com.GridFlow.GridFlow;

import com.GridFlow.GridFlow.processing.processor.Processor;
import com.GridFlow.GridFlow.processing.processor.impl.LoggingProcessor;
import com.GridFlow.GridFlow.processing.processor.impl.TransformProcessor;
import com.GridFlow.GridFlow.receiver.processor.EnrichProcessor;
import com.GridFlow.GridFlow.sender.processor.DataStoringProcessor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
// test
@Component
public class ProcessorRegistry {

    private final Map<String, Processor> processors = new HashMap<>();

    public ProcessorRegistry(LoggingProcessor loggingProcessor, TransformProcessor transformProcessor,
                             EnrichProcessor enrichProcessor, DataStoringProcessor dataStoringProcessor) {
        processors.put("logging", loggingProcessor);
        processors.put("transform", transformProcessor);
        processors.put("enrich", enrichProcessor);
        processors.put("datastoring", dataStoringProcessor);
    }

    public Processor getProcessor(String name) {
        return processors.get(name);
    }
}
