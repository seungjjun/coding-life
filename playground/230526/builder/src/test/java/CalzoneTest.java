import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalzoneTest {
    @Test
    void creation() {
        Calzone calzone = new Calzone.Builder().addTopping(Pizza.Topping.HAM).sauceInside().build();

        assertNotNull(calzone);
    }
}
