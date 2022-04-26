package factory.product;

import factory.product.part.Engine;
import factory.product.part.Tire;

public class SuperBus extends Vehicle {
    public static final String NAME = "Super Bus";

    public SuperBus() {
        name = NAME;
        engine = Engine.HYBRID;
        tire = Tire.NORMAL;
    }
}
