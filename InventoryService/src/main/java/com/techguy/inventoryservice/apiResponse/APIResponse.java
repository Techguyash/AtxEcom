package com.techguy.inventoryservice.apiResponse;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class APIResponse<T>
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

    public void setPayload(T payload)
    {
        this.payload = payload;
    }

    private Boolean isError = false;
    private String errorMessage = null;
    private String debugMessage = null;
    private T payload;

    public APIResponse(T data)
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
