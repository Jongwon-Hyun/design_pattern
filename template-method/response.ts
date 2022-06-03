export class Response<T> {
    constructor(
        private readonly _body: T,
        private readonly _status: number,
    ) {}

    get status(): number {
        return this._status;
    }
}