package com.atx.atxecom.exception;


import com.atx.atxecom.apiResponse.APIResponse;
import com.atx.atxecom.apiResponse.ApiResponseError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<APIResponse> handlerDataNotFoundException(NoDataFoundException ex)
    {

        APIResponse response = new APIResponse();
        response.setError(Boolean.TRUE);
        response = ApiResponseError.returnApiResponse(response, ex);
        ex.printStackTrace();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<APIResponse> handleNullPointerExceptions(NullPointerException ex)
    {
        APIResponse response = new APIResponse();
        response.setError(Boolean.TRUE);
        response = ApiResponseError.returnApiResponse(response, ex);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request)
    {
        ex.printStackTrace();
        APIResponse response = new APIResponse();
        response.setError(Boolean.TRUE);
        Map<String, String> errorBody = new HashMap<>();
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        for (FieldError error : fieldErrors)
        {
            errorBody.put(error.getField(), error.getDefaultMessage());
        }
        response.setPayload(errorBody);
        response = ApiResponseError.returnApiResponse(response, ex);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<APIResponse> handleGenericException(Exception ex)
    {
        System.out.println("Caught the error here");
        APIResponse response = new APIResponse();
        response.setError(Boolean.TRUE);
        response = ApiResponseError.returnApiResponse(response, ex);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SQLException.class)
    protected ResponseEntity<APIResponse> handleSQLException(Exception e)
    {

        APIResponse response = new APIResponse();
        response.setError(Boolean.TRUE);
        response = ApiResponseError.returnApiResponse(response, e);
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
}
