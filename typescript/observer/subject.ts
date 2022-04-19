import { Observer } from "./observer";

export interface Subject {
    subscribe(observer: Observer): void
    unsubscribe(observer: Observer): void
    publish(message: string): void
}