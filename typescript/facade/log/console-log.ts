import { Log } from "./log";

export class ConsoleLog implements Log {
    info(message: string): void {
        console.log(`INFO : ${message}`);
    }

    warn(message: string): void {
        console.log(`WARN : ${message}`);
    }

    fatal(message: string): void {
        console.log(`FATAL : ${message}`);
    }
}