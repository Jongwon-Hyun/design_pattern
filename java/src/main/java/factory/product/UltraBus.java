package factory.product;

import factory.product.part.Engine;
import factory.product.part.Tire;

public class UltraBus extends Vehicle {
    public static final String NAME = "Ultra Bus";

    public UltraBus() {
        name = NAME;
        engine = Engine.GASOLINE;
        tire = Tire.NORMAL;
    }
}
