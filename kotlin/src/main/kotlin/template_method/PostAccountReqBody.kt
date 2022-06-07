package template_method

import template_method.exception.BadRequestException

data class PostAccountReqBody(val accountNumber: String, val branchCode: String) : RequestBody {
    init {
        if (accountNumber.length != 5) {
            throw BadRequestException("invalid account Number")
        }

        if (branchCode.length != 3) {
            throw BadRequestException("invalid branch code")
        }
    }
}
