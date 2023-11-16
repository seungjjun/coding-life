package coding.test.practice;

import java.util.Scanner;

public class TwoPointer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int answer = 1;

        int start = 1;
        int end = 1;
        int sum = 1;

        while (end != N) {
            if(sum == N) {
                answer += 1;
                end += 1;
                sum += end;
            }

            if(sum > N) {
                sum -= start;
                start += 1;
            }

            if(sum < N) {
                end += 1;
                sum += end;
            }
        }

        System.out.println(answer);
    }
}

/*
슈도코드

자연수 N을 입력받는다.

정답 answer 을 1로 초기화 한다. (자기 자신 경우의 수)
두개의 포인터로 사용할 int형 변수 start, end 변수를 선언한다.
합을 저장할 변수 sum을 선언한다.
while(end가 N이 될때가지) {
    if(sum == N) {
        answer += 1;
        end += 1;
        sum += end;
    }
    end를 1씩늘리면서 start부터 end 까지 합을 구하고 아래 조건을 비교한다.
    합이 N과 같으면 end 증가, answer 증가, sum += end

    합이 N보다 크면 합 - start, start 증가

    합이 N보다 작으면 end 증가, sum += end;
}

결과 출력

 */