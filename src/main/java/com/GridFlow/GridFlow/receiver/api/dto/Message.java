package com.GridFlow.GridFlow.receiver.api.dto;

import java.util.Map;

public class Message {
    private String body;
    private Map<String, String> headers;

    // Constructors
    public Message(String body, Map<String, String> headers) {
        this.body = body;
        this.headers = headers;
    }

    // Getters and setters
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
}

