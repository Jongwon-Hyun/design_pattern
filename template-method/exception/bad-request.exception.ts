export class BadRequestException extends Error {
    constructor(readonly _message: string) {
        super(_message)
    }
}