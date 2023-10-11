package com.ipze.self_assessment.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ApiResponse {
    private boolean success = true;
    private Object data;
    private String message;

    public ApiResponse(Object data, String message) {
        this.data = data;
        this.message = message;
    }

    public ApiResponse() {
    }

    @JsonProperty("data")
    public Object getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Object data) {
        this.data = data;
    }
}
