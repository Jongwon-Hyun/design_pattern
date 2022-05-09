import { Engine } from './part/engine'
import { Option } from './part/option';
import { Tire } from './part/tire'

export abstract class Vehicle {
    protected name: string;
    protected engine: Engine
    protected tire: Tire;
    protected options: Array<Option>;

    abstract assembly(): void;

    loadShip() {
        console.log("배에 선적");
    };

    getEngine(): Engine {
        return this.engine;
    }

    getTire(): Tire {
        return this.tire;
    }

    getOptions(): Array<Option> {
        return this.options;
    }

    getName(): string {
        return this.name
    }
}