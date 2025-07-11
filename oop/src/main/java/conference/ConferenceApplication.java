package conference;

import conference.domain.Conference;
import conference.domain.Session;
import java.time.LocalDateTime;
import conference.policy.FreeCancellationPolicy;
import conference.policy.PaidSessionCancellationPolicy;

public class ConferenceApplication {

    public static void main(String[] args) {
        // 1. domain.Conference 객체 생성하기
        Conference conference = new Conference();

        // 2025년 8월 10일 오전 10시 ~ 11시
        Session sessionA = new Session(
            new FreeCancellationPolicy(),
            "객체지향 시작하기",
            LocalDateTime.of(2025, 8, 10, 10, 0),
            LocalDateTime.of(2025, 8, 10, 11, 0),
            100);
        conference.addSession(sessionA);

        // 오전 10시 30분 ~ 11시 30분 (sessionA와 겹침)
        Session sessionB = new Session(
            new PaidSessionCancellationPolicy(),
            "자바 스트림 마스터",
            LocalDateTime.of(2025, 8, 10, 10, 30),
            LocalDateTime.of(2025, 8, 10, 11, 30),
            100);

        try {
            conference.addSession(sessionB);
        } catch (IllegalArgumentException e) {
            System.out.println("예외 발생 확인: " + e.getMessage());
        }
    }
}
