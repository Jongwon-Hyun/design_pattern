package template_method

class PostAccountController : BasePostController<PostAccountReqBody, PostAccountResBody, String>() {
    fun createAccount(requestBody: PostAccountReqBody): Response<*> {
        return execute(requestBody)
    }

    override fun mapToDto(requestBody: PostAccountReqBody): String {
        return requestBody.branchCode + requestBody.accountNumber
    }

    override fun doService(accountNumber: String): PostAccountResBody {
        return PostAccountResBody(accountNumber)
    }

    override fun createResponse(responseBody: PostAccountResBody): Response<PostAccountResBody> {
        return Response(responseBody, 201)
    }
}