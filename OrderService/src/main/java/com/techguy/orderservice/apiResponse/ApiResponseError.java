package com.techguy.orderservice.apiResponse;

public class ApiResponseError
{
    public synchronized static APIResponse returnApiResponse(APIResponse response, Throwable e)
    {
        if (response == null || response.getError())
        {
            if (response == null)
            {
                response = new APIResponse();
            }
            response.setError(Boolean.TRUE);
            response.setSuccess(Boolean.FALSE);
            response.setErrorMessage(e.getMessage());
            response.setDebugMessage(e.getLocalizedMessage());

        }
        return response;
    }
}
