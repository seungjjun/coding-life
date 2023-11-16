package coding.test.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoPointer2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        int M = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int[] numbers = new int[N];
        for (int i = 0; i < numbers.length; i += 1) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(numbers);

        int answer = 0;
        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            if(numbers[start] + numbers[end] == M) {
                answer += 1;
                start += 1;
                end -= 1;
                continue;
            }

            if(numbers[start] + numbers[end] > M) {
                end -= 1;
                continue;
            }

            if(numbers[start] + numbers[end] < M) {
                start += 1;
            }
        }

        System.out.println(answer);
    }
}

/*
슈도코드

재료의 개수 N, 갑옷을 만드는데 필요한 수 M 을 입력 받는다.
N개의 재료들이 가진 고유한 번호를 저장할 1차원 배열 numbers 를 만들고 입력 받는다.
1차원 배열을 오름차순으로 정렬한다.
정답 변수 answer을 선언한다.
두 개의 포인터 start = 0, end = numbers.length - 1 를 선언한다.

while(start != end) {
    만일 numbers[start] + numbers[end]이 M과 같으면 answer을 1더하고 start += 1, end -= 1
    M보다 작으면 start를 1늘린다.
    M보다 크면 end를 1 줄인다.
}

결과값 출력
 */