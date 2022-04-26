package factory_method.product;

import factory_method.product.part.Engine;
import factory_method.product.part.Tire;

public class UltraTruck extends Vehicle {
    public static final String NAME = "Ultra Truck";

    public UltraTruck() {
        name = NAME;
        engine = Engine.HYBRID;
        tire = Tire.OFFLOAD;
    }
}
