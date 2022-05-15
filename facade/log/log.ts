export interface Log {
    info(message: string): void;
    warn(message: string): void;
    fatal(message: string): void;
}