package conference.policy;

import conference.domain.Session;
import java.time.LocalDateTime;

public interface CancellationPolicy {

    /**
     * 해당 세션의 취소가 가능한지 확인합니다.
     * @param session 취소를 요청한 세션
     * @param cancellationTime 취소 시도 시간
     */
    void verify(Session session, LocalDateTime cancellationTime);
}
