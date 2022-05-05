import org.junit.jupiter.api.Test;
import singleton.Singleton;

import static org.junit.jupiter.api.Assertions.assertSame;

public class SingletonTest {
    @Test
    void singletonTest() {
        final var instanceA = Singleton.getInstance();
        final var instanceB = Singleton.getInstance();

        assertSame(instanceA, instanceB);
    }
}