import java.util.ArrayList;
import java.util.List;

public class ValueList {
    private final List<Customer> values;
    public ValueList() {
        this.values = new ArrayList<>();
    }

    public List<Customer> getValues() {
        return values;
    }

    public boolean containsOnlyNull() {
        for (Object obj : values) {
            if (obj != null) {
                return false;
            }
        }
        return true;
    }

    public void add(Customer value) {
        this.values.add(value);
    }
}
