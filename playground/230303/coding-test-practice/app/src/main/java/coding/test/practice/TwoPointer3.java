package coding.test.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoPointer3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        long[] numbers = new long[N];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < numbers.length; i += 1) {
            numbers[i] = Long.parseLong(stringTokenizer.nextToken());
        }
        Arrays.sort(numbers);

        int answer = 0;

        for (int i = 0; i < numbers.length; i += 1) {
            int start = 0;
            int end = numbers.length - 1;
            long findNumber = numbers[i];

            while (start < end) {
                if(numbers[start] + numbers[end] == findNumber) {
                    if(start != i && end != i) {
                        answer += 1;
                        break;
                    } else if (start == i) {
                        start += 1;
                    } else {
                        end -= 1;
                    }
                } else if(numbers[start] + numbers[end] > findNumber) {
                    end -= 1;
                } else {
                    start += 1;
                }
            }
        }

        System.out.println(answer);
    }
}

/*
슈도코드

수의 개수 N을 입력받는다.
N개의 수의 값을 입력 받고 int형 1차원 배열 numbers에 저장한다.
numbers를 오름차순으로 정렬한다.

정답을 기록할 int형 변수 answer를 선언한다.
for(numbers 길이만큼 반복) {
    두 개의 포인터 start = 0, end = numbers.length - 1을 선언한다.
    찾고자 하는 값 findNumber 를 numbers[i] 부터 차례대로 넣고 아래 조건을 비교한다.

    while(start < end) {
        만일 numbers[start] + numbers[end] == findNumber 이면 answer += 1, start += 1, end -= 1;
        numbers[start] + numbers[end] > findNumber 이면 end -= 1,
        numbers[start] + numbers[end] < findNumber 이면 start += 1
    }
}
 */