package library.vo;

import java.util.Objects;

public class Isbn {

    private final String value;

    public Isbn(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("ISBN must not be null or blank");
        }
        if (value.length() != 13) {
            throw new IllegalArgumentException("ISBN must be exactly 13 lengths");
        }
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Isbn isbn = (Isbn) o;
        return Objects.equals(value, isbn.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
