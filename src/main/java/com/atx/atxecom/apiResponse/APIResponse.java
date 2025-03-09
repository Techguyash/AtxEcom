package com.atx.atxecom.apiResponse;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

public class APIResponse
{
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    private Boolean isSuccess = true;

    public LocalDateTime getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp)
    {
        this.timestamp = timestamp;
    }

    public Boolean getSuccess()
    {
        return isSuccess;
    }

    public void setSuccess(Boolean success)
    {
        isSuccess = success;
    }

    public Boolean getError()
    {
        return isError;
    }

    public void setError(Boolean error)
    {
        isError = error;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }

    public String getDebugMessage()
    {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage)
    {
        this.debugMessage = debugMessage;
    }

    public Object getPayload()
    {
        return payload;
    }

    public void setPayload(Object payload)
    {
        this.payload = payload;
    }

    private Boolean isError = false;
    private String errorMessage = null;
    private String debugMessage = null;
    private Object payload;

    public APIResponse(Object data)
    {
        this();
        this.payload = data;
        this.timestamp = LocalDateTime.now();
    }

    public APIResponse()
    {
        this.timestamp = LocalDateTime.now();
    }
}
