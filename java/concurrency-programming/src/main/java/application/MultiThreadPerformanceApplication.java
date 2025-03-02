package application;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThreadPerformanceApplication {

    // 임계 영역
    private int sharedCounter = 0;

    private synchronized void doHeavyWork() {
        for (int i = 0; i < 1_000_000; i++) {
            sharedCounter++;
        }
    }

    private void runMultiThreadTask() throws InterruptedException {
        long startTime = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // 100개의 작업을 멀티 스레드에서 실행
        for (int i = 0; i < 100; i++) {
            executorService.submit(this::doHeavyWork);
        }

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.MINUTES);

        long endTime = System.currentTimeMillis();
        System.out.println("[Multi-thread] Total time: " + (endTime - startTime) + " ms");
        System.out.println("[Multi-thread] Final sharedCounter: " + sharedCounter);
    }

    private void runSingleThreadTask() {
        long startTime = System.currentTimeMillis();

        // 100개의 작업을 단일 스레드(메인 스레드)에서 순차 실행
        for (int i = 0; i < 100; i++) {
            doHeavyWork();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("[Single-thread] Total time: " + (endTime - startTime) + " ms");
        System.out.println("[Single-thread] Final sharedCounter: " + sharedCounter);
    }

    public static void main(String[] args) throws InterruptedException {
        MultiThreadPerformanceApplication application = new MultiThreadPerformanceApplication();

        System.out.println("=== Single Thread Test ===");
        application.runSingleThreadTask();

        // sharedCounter 값이 누적되지 않도록 새 객체 생성 (또는 sharedCounter 초기화)
        application = new MultiThreadPerformanceApplication();
        System.out.println("\n=== Multi Thread Test ===");
        application.runMultiThreadTask();
    }
}
