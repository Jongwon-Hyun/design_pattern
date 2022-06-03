import { PostAccountReqBody } from "./post-account-req-body";
import { PostAccountController } from "./post-account.controller";

test('Test Template Method', () => {
    const controller = new PostAccountController();
    const response = controller.createAccount(new PostAccountReqBody("12345", "123"));
    expect(response.status).toEqual(201);
});