package com.GridFlow.GridFlow.processing.processor;

import com.GridFlow.GridFlow.receiver.api.dto.Message;

public interface Processor {
    void process(Message message);
}
