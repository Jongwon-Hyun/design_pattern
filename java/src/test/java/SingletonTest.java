import org.junit.jupiter.api.Test;
import singleton.Singleton;

import static org.junit.jupiter.api.Assertions.assertSame;

public class SingletonTest {
    @Test
    void singletonTest() {
        var instanceA = Singleton.getInstance();
        var instanceB = Singleton.getInstance();

        assertSame(instanceA, instanceB);
    }
}