import { BadRequestException } from "./exception/bad-request.exception";
import { RequestBody } from "./request-body";

export class PostAccountReqBody implements RequestBody {
    constructor(
        private readonly _accountNumber: string,
        private readonly _branchCode: string,
    ) {
        if (this._accountNumber.length != 5) {
            throw new BadRequestException('invalid account number');
        }

        if (this._branchCode.length != 3) {
            throw new BadRequestException('invalid branch code');
        }
    }

    get accountNumber(): string {
        return this._accountNumber;
    }

    get branchCode(): string {
        return this._branchCode;
    }
}