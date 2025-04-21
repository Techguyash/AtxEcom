package com.techguy.orderservice.exception;

/**
 * @author ashiq
 * @createdOn 16/03/25 1:14 pm
 * @project AtxEcom
 **/
public class DataMismatchException extends RuntimeException
{
    public DataMismatchException(String message, Throwable cause)
    {
        super(message, cause);
    }
    public DataMismatchException(String message)
    {
        super(message);
    }
}
