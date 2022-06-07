import { ResponseBody } from "./response-body";

export class PostAccountResBody implements ResponseBody {
    constructor(
        private readonly accountNumber: string
    ) {}
}