package domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import policy.CancellationPolicy;

public class Session {

    private final CancellationPolicy cancellationPolicy;

    private final String title;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;

    private final int capacity;
    private final List<Attendee> attendees = new ArrayList<>();
    private final Queue<Attendee> waitingList = new LinkedList<>();

    public Session(CancellationPolicy cancellationPolicy, String title,
                   LocalDateTime startTime, LocalDateTime endTime,
                   int capacity) {
        this.cancellationPolicy = cancellationPolicy;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.capacity = capacity;
    }

    public boolean hasOverlap(LocalDateTime startTime, LocalDateTime endTime) {
        return startTime.isBefore(this.endTime) && endTime.isAfter(this.startTime);
    }

    public void addAttendee(Attendee attendee) {
        if (this.attendees.size() >= capacity) {
            waitingList.add(attendee);
            return;
        }
        if (this.attendees.contains(attendee)) {
            throw new IllegalArgumentException("Attendee already registered");
        }
        this.attendees.add(attendee);
    }

    public void removeAttendee(Attendee attendee) {
        if (!this.attendees.contains(attendee)) {
            throw new IllegalArgumentException("Attendee not registered for this session");
        }
        this.cancellationPolicy.verify(this, LocalDateTime.now());

        boolean removed = this.attendees.remove(attendee);
        if (!removed) {
            if (this.waitingList.remove(attendee)) {
                System.out.println("Attendee removed from waiting list");
                return;
            }
            throw new IllegalArgumentException("Attendee not found in session or waiting list");
        }

        if (!waitingList.isEmpty()) {
            Attendee nextAttendee = waitingList.poll();

            this.attendees.add(nextAttendee);

            nextAttendee.addSessionToSchedule(this);
        }
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Attendee> getAttendees() {
        return attendees;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Session session = (Session) o;
        return capacity == session.capacity && Objects.equals(title, session.title) &&
            Objects.equals(startTime, session.startTime) && Objects.equals(endTime, session.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, startTime, endTime, capacity);
    }
}
