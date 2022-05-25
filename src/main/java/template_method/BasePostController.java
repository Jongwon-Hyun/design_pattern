package template_method;

import template_method.exception.ApplicationException;
import template_method.exception.BadRequestException;
import template_method.exception.ErrorResponse;

public abstract class BasePostController<RQ extends RequestBody, RS extends ResponseBody, Dto> {

    public final Response<?> execute(RQ requestBody) {
        try {
            checkRequest(requestBody);
            return createResponse(doService(mapToDto(requestBody)));
        } catch (BadRequestException e) {
            return createErrorResponse(e.getMessage(), 400);
        } catch (ApplicationException e) {
            return createErrorResponse(e.getMessage(), e.getStatus());
        } catch (Exception e) {
            return createErrorResponse(e.getMessage(), 500);
        }
    }

    // Hook Method
    protected void checkRequest(RQ requestBody) {
    }

    protected abstract Dto mapToDto(RQ requestBody);

    protected abstract RS doService(Dto dto);

    protected abstract Response<RS> createResponse(RS responseBody);

    private Response<ErrorResponse> createErrorResponse(String message, int status) {
        return new Response<>(new ErrorResponse(message), status);
    }

}
