package factory.product;

import factory.product.part.Engine;
import factory.product.part.Tire;

public class UltraTruck extends Vehicle {
    public static final String NAME = "Ultra Truck";

    public UltraTruck() {
        name = NAME;
        engine = Engine.HYBRID;
        tire = Tire.OFFLOAD;
    }
}
