import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello";
        });

        String result = future.get();
        System.out.println("result = " + result);

        CompletableFuture<String> companyNameFuture = CompletableFuture.supplyAsync(() -> getCompanyName("005930"));
        CompletableFuture<String> companyPriceFuture =
            companyNameFuture.thenApply(CompletableFutureExample::getCompanyPrice);

        String result2 = companyPriceFuture.get();
        System.out.println("thenApply() result = " + result2);

        CompletableFuture.allOf(future, companyNameFuture, companyPriceFuture).get();
    }

    private static String getCompanyPrice(String companyName) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return companyName + "의 주가: 59,000원";
    }

    private static String getCompanyName(String code) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "기업코드: " + code + ", 삼성전자";
    }
}
