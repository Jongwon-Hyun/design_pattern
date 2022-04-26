import { Engine } from './part/engine'
import { Tire } from './part/tire'

export abstract class Vehicle {
    protected name: string;
    protected engine: Engine
    protected tire: Tire;

    public assembly() {
        console.log(`${this.engine} 엔진을 장착`);
        console.log(`${this.tire} 타이어를 장착`);
    }

    public loadShip() {
        console.log("배에 선적");
    };

    public getEngine(): Engine {
        return this.engine;
    }

    public getTire(): Tire {
        return this.tire;
    }

    public getName(): string {
        return this.name
    }
}