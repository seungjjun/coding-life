import domain.Session;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import policy.FreeCancellationPolicy;
import static org.junit.jupiter.api.Assertions.*;

class SessionTest {

    @Test
    void hasOverlap() {
        Session sessionA = new Session(
            new FreeCancellationPolicy(),
            "Test domain.Session A",
            LocalDateTime.of(2025, 8, 10, 10, 0),
            LocalDateTime.of(2025, 8, 10, 11, 0),
            100);

        Session sessionB = new Session(
            new FreeCancellationPolicy(),
            "Test domain.Session B",
            LocalDateTime.of(2025, 8, 10, 10, 30),
            LocalDateTime.of(2025, 8, 10, 11, 30),
            100);

        assertTrue(sessionA.hasOverlap(sessionB.getStartTime(), sessionB.getEndTime()));
    }

    @Test
    void notOverlap() {
        Session sessionA = new Session(
            new FreeCancellationPolicy(),
            "Test domain.Session A",
            LocalDateTime.of(2025, 8, 10, 10, 0),
            LocalDateTime.of(2025, 8, 10, 11, 0),
            100);

        Session sessionB = new Session(new FreeCancellationPolicy(),
            "Test domain.Session B",
            LocalDateTime.of(2025, 8, 10, 11, 30),
            LocalDateTime.of(2025, 8, 10, 12, 30),
            100);

        assertFalse(sessionA.hasOverlap(sessionB.getStartTime(), sessionB.getEndTime()));
    }
}
