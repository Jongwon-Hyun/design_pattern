package template_method;

public class PostAccountController extends BasePostController<PostAccountReqBody, PostAccountResBody, String> {

    public Response<?> createAccount(PostAccountReqBody requestBody) {
        return execute(requestBody);
    }

    @Override
    protected String mapToDto(PostAccountReqBody requestBody) {
        return requestBody.branchCode() + requestBody.accountNumber();
    }

    @Override
    protected PostAccountResBody doService(String accountNumber) {
        return new PostAccountResBody(accountNumber);
    }

    @Override
    protected Response<PostAccountResBody> createResponse(PostAccountResBody responseBody) {
        return new Response<>(responseBody, 201);
    }
}
