import domain.Conference;
import domain.Session;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import policy.FreeCancellationPolicy;
import static org.junit.jupiter.api.Assertions.*;

class ConferenceTest {

    @Test
    void createConference() {
        Conference conference = new Conference();
        assertNotNull(conference);
    }

    @Test
    void addSession() {
        Conference conference = new Conference();
        Session session = new Session(
            new FreeCancellationPolicy(),
            "Test domain.Session",
            LocalDateTime.of(2025, 8, 10, 10, 0),
            LocalDateTime.of(2025, 8, 10, 11, 0),
            100);

        conference.addSession(session);

        assertEquals(1, conference.getSessions().size());
    }

    @Test
    void overlapSession() {
        Conference conference = new Conference();
        Session sessionA = new Session(
            new FreeCancellationPolicy(),
            "Test domain.Session",
            LocalDateTime.of(2025, 8, 10, 10, 0),
            LocalDateTime.of(2025, 8, 10, 11, 0),
            100);

        conference.addSession(sessionA);

        Session sessionB = new Session(
            new FreeCancellationPolicy(),
            "Test domain.Session",
            LocalDateTime.of(2025, 8, 10, 10, 30),
            LocalDateTime.of(2025, 8, 10, 11, 30),
            100);

        assertThrows(IllegalArgumentException.class, () -> {
            conference.addSession(sessionB);
        });
    }

}
