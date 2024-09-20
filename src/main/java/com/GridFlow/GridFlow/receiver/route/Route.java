package com.GridFlow.GridFlow.receiver.route;

import com.GridFlow.GridFlow.processing.processor.Processor;
import com.GridFlow.GridFlow.receiver.api.dto.Context;
import com.GridFlow.GridFlow.receiver.api.dto.Message;

public interface Route {
    Route addProcessor(Processor processor);
    void setNextRoute(Route nextRoute);
    void execute(Message message);
    void execute(Message message, Context context);
}
