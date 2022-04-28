package abstract_factory.product.part;

import java.util.List;

public class CityVehiclePartFactory implements VehiclePartFactory {
    @Override
    public Engine createEngine() {
        return Engine.HYBRID;
    }

    @Override
    public Tire createTire() {
        return Tire.NORMAL;
    }

    @Override
    public List<Option> createOptions() {
        return List.of(Option.NAVIGATION, Option.CRUISE_CONTROL);
    }
}
