package factory_method.product;

import factory_method.product.part.Engine;
import factory_method.product.part.Tire;

public class UltraBus extends Vehicle {
    public static final String NAME = "Ultra Bus";

    public UltraBus() {
        name = NAME;
        engine = Engine.GASOLINE;
        tire = Tire.NORMAL;
    }
}