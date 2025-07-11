package domain;

import java.util.ArrayList;
import java.util.List;

public class Conference {

    private final List<Session> sessions = new ArrayList<>();
    private final List<Room> rooms = new ArrayList<>();

    public void addSession(Session newSession) {
        boolean isTimeOverlapSession = sessions.stream()
            .anyMatch(session -> session.hasOverlap(newSession.getStartTime(), newSession.getEndTime()));
        if (isTimeOverlapSession) {
            throw new IllegalArgumentException("Session already exists");
        }
        this.sessions.add(newSession);
    }

    public void registerToSession(String sessionTitle, Attendee attendee) {
        Session foundSession = findSessionByTitle(sessionTitle);
        attendee.registerFor(foundSession);
    }

    private Session findSessionByTitle(String sessionTitle) {
        return sessions.stream()
            .filter(s -> s.getTitle().equals(sessionTitle))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Session not found"));
    }

    public List<Session> getSessions() {
        return new ArrayList<>(sessions);
    }
}
