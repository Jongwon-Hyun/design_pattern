import { BasePostController } from "./base-post-controller";
import { PostAccountReqBody } from "./post-account-req-body";
import { PostAccountResBody } from "./post-account-res- body";
import { Response } from "./response";

export class PostAccountController extends BasePostController<PostAccountReqBody, PostAccountResBody, string> {
    public createAccount(requestBody: PostAccountReqBody): Response<any> {
        return this.execute(requestBody);
    }

    protected mapToDto(requestBody: PostAccountReqBody): string {
        return requestBody.branchCode + requestBody.accountNumber;
    }

    protected doService(accountNumber: string): PostAccountResBody {
        return new PostAccountResBody(accountNumber);
    }

    protected createResponse(responseBody: PostAccountResBody ): Response<PostAccountResBody> {
        return new Response(responseBody, 201);
    }
}