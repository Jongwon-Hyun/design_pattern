import { Engine } from './engine';
import { Tire } from './tire';
import { Option } from './option';

export interface VehiclePartFactory {
   createEngine(): Engine;
   createTire(): Tire;
   createOptions(): Array<Option>;
}