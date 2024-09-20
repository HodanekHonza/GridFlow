package com.GridFlow.GridFlow.processing.service;

import com.GridFlow.GridFlow.receiver.api.dto.Message;
import org.springframework.stereotype.Service;

@Service
public class TransformationService {
    public void transform(Message message) {
        System.out.println("TRANSFORM SERVICE");
       // String transformedBody = message.getBody().toUpperCase();
        //message.setBody(transformedBody);
    }
}
