import java.util.HashMap;
import java.util.Map;

// user의 아이디가 key값이 되야 하는건 분명 ??
// 닉네임도 기록해야하고 enter인지, leave, change인지 구분이 가능해야한다. key - [vale, value]
// 들어간 순서도 유지해야 한다.
// 나갔다가 들어왔을때 닉네임이 변경될 수 있음.

public class OpenChatRoom {
    public String[] solution(String[] records) {
        Map<String, String> userRecord = new HashMap<>();

        int size = 0;
        for (String record : records) {
            String[] action = record.split(" ");

            if (action[0].equals("Enter")) {
                size += 1;
                userRecord.put(action[1], action[2]);
                continue;
            }

            if (action[0].equals("Leave")) {
                size += 1;
                continue;
            }

            if (action[0].equals("Change")) {
                userRecord.put(action[1], action[2]);
            }
        }

        String[] answer = new String[size];
        int index = 0;

        for (String record : records) {
            String result = "";
            String[] action = record.split(" ");

            if (action[0].equals("Change")) {
                continue;
            }

            if (action[0].equals("Enter")) {
                result = userRecord.get(action[1]) + "님이 들어왔습니다.";
            }

            if (action[0].equals("Leave")) {
                result = userRecord.get(action[1]) + "님이 나갔습니다.";
            }

            answer[index] = result;
            index += 1;
        }

        return answer;
    }
}
