package com.GridFlow.GridFlow.sender.processor;

import com.GridFlow.GridFlow.processing.processor.Processor;
import com.GridFlow.GridFlow.receiver.api.dto.Message;
import com.GridFlow.GridFlow.sender.service.DataStoringService;
import org.springframework.stereotype.Service;

@Service
public class DataStoringProcessorSender implements Processor {

    private final DataStoringService dataStoringService;

    public DataStoringProcessorSender(DataStoringService dataStoringService) {
        this.dataStoringService = dataStoringService;
    }

    @Override
    public void process(Message message) {
        dataStoringService.storeData();
    }
}
