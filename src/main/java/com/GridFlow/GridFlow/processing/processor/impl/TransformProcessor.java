package com.GridFlow.GridFlow.processing.processor.impl;

import com.GridFlow.GridFlow.processing.processor.Processor;
import com.GridFlow.GridFlow.processing.service.TransformService;
import com.GridFlow.GridFlow.receiver.api.dto.Message;
import org.springframework.stereotype.Service;

@Service
public class TransformProcessor implements Processor {

    private final TransformService transformService;

    public TransformProcessor(TransformService transformService) {
        this.transformService = transformService;
    }


    @Override
    public void process(Message message) {
        transformService.transform(message);
    }
}

