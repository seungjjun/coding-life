package coding.test.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrefixSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int[] prefixSum = new int[N + 1];

        for (int i = 1; i < prefixSum.length; i += 1) {
            prefixSum[i] = prefixSum[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        for(int i = 0; i < M; i += 1) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());

            System.out.println(prefixSum[end] - prefixSum[start - 1]);
        }
    }
}

/*
최초 슈도 코드
데이터의 개수 N과 합을 구해야 하는 횟수 M을 입력받는다.
N개의 개수 만큼의 길이를 갖는 int 형 1차원 배열 numbers를 선언해 숫자를 입력받는다.

구간 합을 저장할 길이가 N인 int형 1차원 배열 prefixSum을 선언
for(N 만큼 반복) {
    prefixSum[i] = prefixSum[i - 1] + numbers[i];
}

for(M 만큼 반복) {
    합을 구해야 하는 구간 i와 j를 입력받는다.
    구간 합 출력(prefixSum[j] - prefixSum[i - 1])
}
 */