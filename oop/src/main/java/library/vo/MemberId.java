package library.vo;

import java.util.Objects;

public class MemberId {

    private final String value;

    public MemberId(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MemberId memberId = (MemberId) o;
        return Objects.equals(value, memberId.value);
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
