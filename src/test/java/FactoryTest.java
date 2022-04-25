import factory.creator.SuperVehicleFactory;
import factory.creator.UltraVehicleFactory;
import factory.product.*;
import factory.product.part.Engine;
import factory.product.part.Tire;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactoryTest {
    @Test
    void testFactory() {
        var superVehicleFactory = new SuperVehicleFactory();
        var ultraVehicleFactory = new UltraVehicleFactory();

        var superBus = superVehicleFactory.orderVehicle(VehicleType.BUS);
        assertEquals(SuperBus.NAME, superBus.getName());
        assertEquals(Engine.HYBRID, superBus.getEngine());
        assertEquals(Tire.NORMAL, superBus.getTire());

        var superTruck = superVehicleFactory.orderVehicle(VehicleType.TRUCK);
        assertEquals(SuperTruck.NAME, superTruck.getName());
        assertEquals(Engine.GASOLINE, superTruck.getEngine());
        assertEquals(Tire.OFFLOAD, superTruck.getTire());

        var ultraBus = ultraVehicleFactory.orderVehicle(VehicleType.BUS);
        assertEquals(UltraBus.NAME, ultraBus.getName());
        assertEquals(Engine.GASOLINE, ultraBus.getEngine());
        assertEquals(Tire.NORMAL, ultraBus.getTire());

        var ultraTruck =  ultraVehicleFactory.orderVehicle(VehicleType.TRUCK);
        assertEquals(UltraTruck.NAME, ultraTruck.getName());
        assertEquals(Engine.HYBRID, ultraTruck.getEngine());
        assertEquals(Tire.OFFLOAD, ultraTruck.getTire());
    }
}
