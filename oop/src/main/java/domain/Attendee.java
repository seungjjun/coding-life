package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Attendee {

    private final String email;
    private final List<Session> registeredSessions = new ArrayList<>();

    public Attendee(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public List<Session> getRegisteredSessions() {
        return Collections.unmodifiableList(registeredSessions);
    }

    public void registerFor(Session session) {
        boolean hasOverlap = registeredSessions.stream()
            .anyMatch(registeredSession -> registeredSession.hasOverlap(session.getStartTime(), session.getEndTime()));

        if (hasOverlap) {
            throw new IllegalArgumentException("Attendee is already registered for a session at this time.");
        }

        session.addAttendee(this);
        this.registeredSessions.add(session);
    }

    public void cancelRegistrationFor(Session session) {
        session.removeAttendee(this);
        this.registeredSessions.remove(session);
    }

    void addSessionToSchedule(Session session) {
        this.registeredSessions.add(session);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Attendee attendee = (Attendee) o;
        return Objects.equals(email, attendee.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }
}
