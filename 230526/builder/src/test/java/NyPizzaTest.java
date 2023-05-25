import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NyPizzaTest {
    @Test
    void creation() {
        NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.SMALL)
            .addTopping(Pizza.Topping.SAUSAGE)
            .addTopping(Pizza.Topping.OPTION)
            .build();

        assertNotNull(nyPizza);
    }
}
