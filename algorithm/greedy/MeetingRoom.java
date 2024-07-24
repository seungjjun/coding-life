import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MeetingRoom {

	static class Meeting implements Comparable<Meeting> {
		private final int startTime;
		private final int endTime;

		public Meeting(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}

		@Override
		public int compareTo(Meeting o) {
			if (this.endTime == o.endTime) {
				return this.startTime - o.startTime;
			} else {
				return this.endTime - o.endTime;
			}
		}

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int answer = 0;
		List<Meeting> meeting = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int startTime = scanner.nextInt();
			int endTime = scanner.nextInt();
			meeting.add(new Meeting(startTime, endTime));
		}
		Collections.sort(meeting);

		Meeting previous = meeting.get(0);
		answer++;
		for (int i = 1; i < meeting.size(); i++) {
			Meeting current = meeting.get(i);
			if (current.startTime < previous.endTime) {
				continue;
			}
			previous = current;
			answer++;
		}

		System.out.println(answer);
	}
}



/*
11
1 4       0 6  -> 6      3 5 -> 2
3 5       1 4  -> 3      5 7 -> 2
0 6       2 13 -> 11     12 14 -> 2
5 7       3 5 -> 2       1 4 -> 3
3 8       3 8 -> 5       8 11 -> 3
5 9       5 7 -> 2       5 9 -> 4
6 10      5 9 -> 4       6 10 -> 4
8 11      6 10 -> 4      8 12 -> 4
8 12      8 11 -> 3      3 8 -> 5
2 13      8 12 -> 4      0 6 -> 6
12 14     12 14 -> 2     2 -> 13 -> 11

11
1 4
3 5
0 6
5 7
3 8
5 9
6 10
8 11
8 12
2 13
12 14
예제 출력 1
4

힌트
(1,4), (5,7), (8,11), (12,14) 를 이용할 수 있다.
(3,5), (5,7), (8, 11), (12, 14)
 겹치지 않는 활동에 대해 종료시간이 빠르면 더 많은 활동을 선택할 수 있는 시간이 많아진다는 것
 */