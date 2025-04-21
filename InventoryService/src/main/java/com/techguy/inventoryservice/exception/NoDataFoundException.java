package com.techguy.inventoryservice.exception;

public class NoDataFoundException extends RuntimeException
{
    public NoDataFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public NoDataFoundException(String message)
    {
        super(message);
    }

    public NoDataFoundException(String key, String value)
    {
        super(String.format(key + " for the value " + value + " is not found"));
    }
}
