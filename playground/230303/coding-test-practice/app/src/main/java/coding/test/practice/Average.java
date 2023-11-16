package coding.test.practice;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] scores = new int[N];

        for (int i = 0; i < N; i += 1) {
            scores[i] = scanner.nextInt();
        }

        long maxScore = 0;
        long sumScore = 0;

        for (int i = 0; i < N; i += 1) {
            if(maxScore < scores[i]) {
                maxScore = scores[i];
            }

            sumScore = sumScore + scores[i];
        }

        System.out.println(sumScore * 100.0 / maxScore / N);
    }
}


/*
슈도코드
시험을 본 과목의 개수 N을 입력 받는다.
N개의 개수 만큼 과목의 점수를 공백을 기준으로 String 형 변수 originalScore 에 저장
공백 기준으로 split 하여 문자열 배열 scores 에 저장
배열의 첫번째 값을 최대 점수를 담는 int형 변수 maxScore 에 저장
반복문을 이용해 점수 배열의 길이만큼 반복하여 하나씩 비교하여 최대 점수를 구한다.
for(scores 길이 만큼) {
     scores[i] = scores[i] / (maxScore * 100)
     새로 구한 과목의 합을 저장하는 int형 변수 sumScore 에 방금 구한 scores[i]를 저장
}

sumScore 를 N으로 나눠서 출력
 */