import { Observer } from "./observer";
import { Subject } from "./subject";

export class Messenger implements Subject {
    observerList = new Array<Observer>();

    subscribe(observer: Observer): void {
        if (!!observer) {
            this.observerList.push(observer);
        }
    }

    unsubscribe(observer: Observer): void {
        const index = this.observerList.findIndex(function(obs) {return observer.getName() === obs.getName()});
        if (index > -1) {
            this.observerList.splice(index, 1);
        }
    }

    publish(message: string): void {
        for (var observer of this.observerList) {
            observer.update(message);
        }
    }
}