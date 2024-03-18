package hashing;

import java.util.*;

/**
 * 문서 도난
 */
public class HashQ6 {

    public static void main(String[] args) {
        HashQ6 q = new HashQ6();
        System.out.println(Arrays.toString(q.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
        System.out.println(Arrays.toString(q.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
        System.out.println(Arrays.toString(q.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
    }

    static class Pair implements Comparable<Pair> {
        String name;
        int time;

        public Pair(String name, int time) {
            this.name = name;
            this.time = time;
        }

        @Override
        public int compareTo(Pair p) {
            return this.time - p.time;
        }
    }

    public String[] solution(String[] reports, String times){
        String[] answer;

        String[] tmp = times.split(" ");
        String[] startTime = tmp[0].split(":");
        String[] endTime = tmp[1].split(":");
        int start = Integer.parseInt(startTime[0]) * 60 + Integer.parseInt(startTime[1]);
        int end = Integer.parseInt(endTime[0]) * 60 + Integer.parseInt(endTime[1]);

        List<Pair> list = new ArrayList<>();
        for (String report : reports) {
            String[] split = report.split(" "); // split[0] = 사람
            String[] time = split[1].split(":");
            int minute = Integer.parseInt(time[0]) * 60;
            int second = Integer.parseInt(time[1]);

            list.add(new Pair(split[0], minute + second));
        }

        Collections.sort(list);

        List<String> names = new ArrayList<>();
        for (Pair p : list) {
            if (start <= p.time && p.time <= end) {
                names.add(p.name);
            }
        }

        answer = new String[names.size()];
        for (int i = 0; i < names.size(); i++) {
            answer[i] = names.get(i);
        }
        return answer;
    }
}
