import { Engine } from './part/engine'
import { Option } from './part/option';
import { Tire } from './part/tire'

export abstract class Vehicle {
    protected name: string;
    protected engine: Engine
    protected tire: Tire;
    protected options: Array<Option>;

    public abstract assembly();

    public loadShip() {
        console.log("배에 선적");
    };

    public getEngine(): Engine {
        return this.engine;
    }

    public getTire(): Tire {
        return this.tire;
    }

    public getOptions(): Array<Option> {
        return this.options;
    }

    public getName(): string {
        return this.name
    }
}