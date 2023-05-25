package coding.test.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SlidingWindow {
    static int[] currentArray;
    static int[] checkArray;
    static int checkSecret;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int answer = 0;
        int S = Integer.parseInt(stringTokenizer.nextToken());
        int P = Integer.parseInt(stringTokenizer.nextToken());
        char[] DNA = bufferedReader.readLine().toCharArray();

        checkArray = new int[4];
        currentArray = new int[4];

        checkSecret = 0;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < 4; i += 1) {
            checkArray[i] = Integer.parseInt(stringTokenizer.nextToken());

            if (checkArray[i] == 0) {
                checkSecret += 1;
            }
        }

        for (int i = 0; i < P; i += 1) {
            add(DNA[i]);
        }

        if (checkSecret == 4) {
            answer += 1;
        }

        for (int end = P; end < S; end += 1) {
            int start = end - P;
            add(DNA[end]);
            remove(DNA[start]);

            if (checkSecret == 4) {
                answer += 1;
            }
        }

        System.out.println(answer);
    }

    private static void add(char alphabet) {
        switch (alphabet) {
            case 'A':
                currentArray[0] += 1;
                if (currentArray[0] == checkArray[0]) {
                    checkSecret += 1;
                }
                break;

            case 'C':
                currentArray[1] += 1;
                if (currentArray[1] == checkArray[1]) {
                    checkSecret += 1;
                }
                break;

            case 'G':
                currentArray[2] += 1;
                if (currentArray[2] == checkArray[2]) {
                    checkSecret += 1;
                }
                break;

            case 'T':
                currentArray[3] += 1;
                if (currentArray[3] == checkArray[3]) {
                    checkSecret += 1;
                }
                break;

        }
    }

    private static void remove(char alphabet) {
        switch (alphabet) {
            case 'A':
                if (currentArray[0] == checkArray[0]) {
                    checkSecret -= 1;
                }
                currentArray[0] -= 1;
                break;

            case 'C':
                if (currentArray[1] == checkArray[1]) {
                    checkSecret -= 1;
                }
                currentArray[1] -= 1;
                break;

            case 'G':
                if (currentArray[2] == checkArray[2]) {
                    checkSecret -= 1;
                }
                currentArray[2] -= 1;
                break;

            case 'T':
                if (currentArray[3] == checkArray[3]) {
                    checkSecret -= 1;
                }
                currentArray[3] -= 1;
                break;

        }
    }
}

/*
슈도코드

DNA 문자열의 길이 P와 부분 문자열의 길이 S를 입력 받는다.
DNA 문자열을 입력받아 char형 배열에 저장한다.
부분 문자열에 포함되어아 햘 A, C, G, T 최소 개수를 입력 받아 int형 배열에 저장한다.
정답을 저장할 answer를 선언한다.
현재 문자열에 포함된 A, C, G, T 의 개수를 저장할 배열을 선언하다.

두 개의 포인터 start = 0, end = S.length - 1; 을 선언한다.
while(end < P.length - 1) {

}
 */