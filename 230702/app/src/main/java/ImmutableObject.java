import java.util.Date;

public class ImmutableObject {
    private final Date mutableField;

    public ImmutableObject(Date newDate) {
        this.mutableField = new Date(newDate.getTime());
    }

    protected Date getMutableField() {
        return new Date(mutableField.getTime());
    }
}


