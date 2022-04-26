package factory_method.product;

import factory_method.product.part.Engine;
import factory_method.product.part.Tire;

public class SuperTruck extends Vehicle {
    public static final String NAME = "Super Truck";

    public SuperTruck() {
        name = NAME;
        engine = Engine.GASOLINE;
        tire = Tire.OFFLOAD;
    }
}
