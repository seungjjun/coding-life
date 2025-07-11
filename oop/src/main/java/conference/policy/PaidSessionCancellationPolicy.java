package conference.policy;

import conference.domain.Session;
import java.time.LocalDateTime;

public class PaidSessionCancellationPolicy implements CancellationPolicy {
    @Override
    public void verify(Session session, LocalDateTime cancellationTime) {
        if (cancellationTime.isAfter(session.getStartTime().minusHours(48))) {
            throw new IllegalStateException("Cannot cancel registration within 24 hours of the session start time");
        }
        System.out.println("Pass cancellation policy check for paid session");
    }
}
