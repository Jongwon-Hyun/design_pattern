package template_method;

import template_method.exception.BadRequestException;

public record PostAccountReqBody(String accountNumber, String branchCode) implements RequestBody {
    public PostAccountReqBody {
        if (accountNumber.length() != 5) {
            throw new BadRequestException("invalid account Number");
        }

        if (branchCode.length() != 3) {
            throw new BadRequestException("invalid branch code");
        }
    }
}
