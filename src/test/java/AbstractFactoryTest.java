import abstract_factory.creator.SuperVehicleFactory;
import abstract_factory.creator.UltraVehicleFactory;
import abstract_factory.product.*;
import abstract_factory.product.part.Engine;
import abstract_factory.product.part.Option;
import abstract_factory.product.part.Tire;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class AbstractFactoryTest {
    @Test
    void testFactoryMethod() {
        var superVehicleFactory = new SuperVehicleFactory();
        var ultraVehicleFactory = new UltraVehicleFactory();

        var superBus = superVehicleFactory.orderVehicle(VehicleType.BUS);
        assertEquals(SuperBus.NAME, superBus.getName());
        assertEquals(Engine.HYBRID, superBus.getEngine());
        assertEquals(Tire.NORMAL, superBus.getTire());
        assertIterableEquals(List.of(Option.NAVIGATION, Option.CRUISE_CONTROL), superBus.getOptions());

        var superTruck = superVehicleFactory.orderVehicle(VehicleType.TRUCK);
        assertEquals(SuperTruck.NAME, superTruck.getName());
        assertEquals(Engine.GASOLINE, superTruck.getEngine());
        assertEquals(Tire.OFFLOAD, superTruck.getTire());
        assertEquals(List.of(), superTruck.getOptions());

        var ultraBus = ultraVehicleFactory.orderVehicle(VehicleType.BUS);
        assertEquals(UltraBus.NAME, ultraBus.getName());
        assertEquals(Engine.GASOLINE, ultraBus.getEngine());
        assertEquals(Tire.OFFLOAD, ultraBus.getTire());
        assertIterableEquals(List.of(Option.NAVIGATION, Option.AUDIO_SYSTEM), ultraBus.getOptions());

        var ultraTruck = ultraVehicleFactory.orderVehicle(VehicleType.TRUCK);
        assertEquals(UltraTruck.NAME, ultraTruck.getName());
        assertEquals(Engine.HYBRID, ultraTruck.getEngine());
        assertEquals(Tire.NORMAL, ultraTruck.getTire());
        assertEquals(List.of(), ultraTruck.getOptions());
    }
}
