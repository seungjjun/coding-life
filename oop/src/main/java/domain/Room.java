package domain;

import java.util.Objects;

public class Room {

    private final String name;
    private final int capacity;

    public Room(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Room room = (Room) o;
        return capacity == room.capacity && Objects.equals(name, room.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, capacity);
    }
}
