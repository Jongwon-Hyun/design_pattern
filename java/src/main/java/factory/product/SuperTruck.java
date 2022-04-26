package factory.product;

import factory.product.part.Engine;
import factory.product.part.Tire;

public class SuperTruck extends Vehicle {
    public static final String NAME = "Super Truck";

    public SuperTruck() {
        name = NAME;
        engine = Engine.GASOLINE;
        tire = Tire.OFFLOAD;
    }
}
