package abstract_factory.product.part;

import java.util.List;

public interface VehiclePartFactory {
    Engine createEngine();

    Tire createTire();

    List<Option> createOptions();
}
