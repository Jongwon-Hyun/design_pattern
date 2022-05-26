package template_method

import template_method.exception.ApplicationException
import template_method.exception.BadRequestException
import template_method.exception.ErrorResponse

abstract class BasePostController<RQ : RequestBody, RS : ResponseBody, Dto> {
    fun execute(reqBody: RQ): Response<*> {
        return try {
            checkRequest(reqBody)
            createResponse(doService(mapToDto(reqBody)))
        } catch (e: BadRequestException) {
            createErrorResponse(e.message ?: "bad request", 400)
        } catch (e: ApplicationException) {
            createErrorResponse(e.message ?: "application error", e.status)
        } catch (e: Exception) {
            createErrorResponse(e.message ?: "unknown error", 500)
        }
    }

    // Hook Method
    open fun checkRequest(requestBody: RQ) {
    }

    protected abstract fun mapToDto(requestBody: RQ): Dto

    protected abstract fun doService(dto: Dto): RS

    protected abstract fun createResponse(responseBody: RS): Response<RS>

    private fun createErrorResponse(message: String, status: Int): Response<ErrorResponse> {
        return Response(ErrorResponse(message), status)
    }
}