package hashing;

import java.util.*;

/**
 * 경고 메일
 */
public class HashQ7 {

    public static void main(String[] args) {
        HashQ7 q = new HashQ7();
        System.out.println(Arrays.toString(q.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));
        System.out.println(Arrays.toString(q.solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
        System.out.println(Arrays.toString(q.solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
        System.out.println(Arrays.toString(q.solution(new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
    }

    public String[] solution(String[] reports, int time){
        String[] answer;

        Map<String, Integer> report = new HashMap<>();
        Map<String, Integer> useTime = new HashMap<>();

        for (String r : reports) {
            String[] split = r.split(" "); // split[0] == 사람 split[1] == 시간 split[2] == in out
            String[] tmp = split[1].split(":");
            int t = Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);

            if (split[2].equals("in")) {
                report.put(split[0], t);
            } else if (split[2].equals("out")) {
                int use = t - report.get(split[0]);
                useTime.put(split[0], useTime.getOrDefault(split[0], 0) + use);
            }
        }

        List<String> names = new ArrayList<>();
        for (String key : useTime.keySet()) {
            if (useTime.get(key) > time) {
                names.add(key);
            }
        }

        Collections.sort(names); // list.sort((a, b) -> a.compareTo(b));
        answer = new String[names.size()];
        for (int i = 0; i < names.size(); i++) {
            answer[i] = names.get(i);
        }

        return answer;
    }
}
