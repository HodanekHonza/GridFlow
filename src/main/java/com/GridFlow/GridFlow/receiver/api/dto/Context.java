package com.GridFlow.GridFlow.receiver.api.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Context {

    private Map<String, DataItemProcessingResultDto> dataItemProcessingResultMap = new HashMap();
    private Message message;
    private String payload;

    public Context() {
    }

    public Context(Map<String, DataItemProcessingResultDto> dataItemProcessingResultMap, Message message, String payload) {
        this.dataItemProcessingResultMap = dataItemProcessingResultMap;
        this.message = message;
        this.payload = payload;
    }

    public Map<String, DataItemProcessingResultDto> getDataItemProcessingResultMap() {
        return dataItemProcessingResultMap;
    }

    public void setDataItemProcessingResultMap(Map<String, DataItemProcessingResultDto> dataItemProcessingResultMap) {
        this.dataItemProcessingResultMap = dataItemProcessingResultMap;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

}
