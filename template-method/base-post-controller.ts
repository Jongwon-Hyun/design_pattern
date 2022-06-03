import { ApplicationException } from "./exception/application.exception";
import { BadRequestException } from "./exception/bad-request.exception";
import { ErrorResponse } from "./exception/error.response";
import { RequestBody } from "./request-body";
import { Response } from "./response";
import { ResponseBody } from "./response-body";

export abstract class BasePostController<RQ extends RequestBody, RS extends ResponseBody, Dto> {
    execute(requestBody: RQ): Response<any> {
        try {
            this.checkRequest(requestBody);
            return this.createResponse(this.doService(this.mapToDto(requestBody)));
        } catch (error) {
            switch (error.constructor){
                case BadRequestException:
                    return this.createErrorResponse(error.message, 400);
                case ApplicationException:
                    return this.createErrorResponse(error.message, error.status);
                default:
                    return this.createErrorResponse(error.message, 500);
            }
        }
    }

    // Hook Method
    protected checkRequest(requestBody: RQ): void {
    }

    protected abstract mapToDto(requestBody: RQ): Dto;

    protected abstract doService(dto: Dto): RS;

    protected abstract createResponse(responseBody: RS): Response<RS>;

    private createErrorResponse(message: string, status: number): Response<ErrorResponse> {
        return new Response<ErrorResponse>(new ErrorResponse(message), status);
    }
}