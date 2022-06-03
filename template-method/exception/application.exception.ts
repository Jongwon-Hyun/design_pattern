export class ApplicationException extends Error {
    constructor(readonly _message: string, private readonly _status: number) {
        super(_message)
    }

    get status(): number {
        return this._status;
    }
}