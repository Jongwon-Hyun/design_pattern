package abstract_factory.product.part;

import java.util.List;

public class OffloadVehiclePartFactory implements VehiclePartFactory {
    @Override
    public Engine createEngine() {
        return Engine.GASOLINE;
    }

    @Override
    public Tire createTire() {
        return Tire.OFFLOAD;
    }

    @Override
    public List<Option> createOptions() {
        return List.of(Option.NAVIGATION, Option.AUDIO_SYSTEM);
    }
}
