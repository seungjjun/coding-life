package conference.policy;

import conference.domain.Session;
import java.time.LocalDateTime;

public class FreeCancellationPolicy implements CancellationPolicy {
    @Override
    public void verify(Session session, LocalDateTime cancellationTime) {
        // 무료 세션은 언제나 취소 가능하므로 아무것도 하지 않음
        return;
    }
}
