package factory_method.product;

import factory_method.product.part.Engine;
import factory_method.product.part.Tire;

public class SuperBus extends Vehicle {
    public static final String NAME = "Super Bus";

    public SuperBus() {
        name = NAME;
        engine = Engine.HYBRID;
        tire = Tire.NORMAL;
    }
}
