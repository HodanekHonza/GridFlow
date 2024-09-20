package com.GridFlow.GridFlow.processing.processor.impl;

import com.GridFlow.GridFlow.processing.processor.Processor;
import com.GridFlow.GridFlow.processing.service.TransformationService;
import com.GridFlow.GridFlow.receiver.api.dto.Message;
import org.springframework.stereotype.Service;

@Service
public class TransformationProcessor implements Processor {

    private final TransformationService transformService;

    public TransformationProcessor(TransformationService transformService) {
        this.transformService = transformService;
    }

    @Override
    public void process(Message message) {
        transformService.transform(message);
    }
}

