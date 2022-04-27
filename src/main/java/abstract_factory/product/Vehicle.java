package abstract_factory.product;

import abstract_factory.product.part.Engine;
import abstract_factory.product.part.Option;
import abstract_factory.product.part.Tire;

import java.util.List;

public abstract class Vehicle {
    protected String name;
    protected Engine engine;
    protected Tire tire;
    protected List<Option> options;

    public abstract void assembly();

    public void loadShip() {
        System.out.println("배에 선적");
    }

    public Engine getEngine() {
        return engine;
    }

    public Tire getTire() {
        return tire;
    }

    public List<Option> getOptions() {
        return options;
    }

    public String getName() {
        return name;
    }
}
