package policy;

import domain.Session;
import java.time.LocalDateTime;

public class NonRefundablePolicy implements CancellationPolicy{
    @Override
    public void verify(Session session, LocalDateTime cancellationTime) {
        throw new IllegalStateException("Non-refundable policy: cancellation is not allowed");
    }
}
