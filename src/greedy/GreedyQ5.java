package greedy;

import java.util.*;

/**
 * 전투 게임
 */
public class GreedyQ5 {

    public static void main(String[] args) {
        GreedyQ5 q = new GreedyQ5();
        System.out.println(Arrays.toString(q.solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
        System.out.println(Arrays.toString(q.solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(q.solution(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(q.solution(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
    }

    static class Info implements Comparable<Info> {
        int idx;
        String team;
        int attack;

        Info(int idx, String team, int attack) {
            this.idx = idx;
            this.team = team;
            this.attack = attack;
        }

        @Override
        public int compareTo(Info i) {
            return this.attack - i.attack;
        }
    }

    public int[] solution(String[] students){
        int n = students.length;
        int[] answer = new int[n];

        List<Info> info = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] split = students[i].split(" "); // split[0] : team split[1] : attack
            info.add(new Info(i, split[0], Integer.parseInt(split[1])));
        }

        Collections.sort(info);

        int sum = 0, j = 0;
        for (int i = 1; i < n; i++) {
            for (; j < n; j++) { // if를 만족하지 않으면 j가 증가하지 않음 -> 이전단계 같은값까지 더할수 있게됨 / 10 11 12 12 20
                if (info.get(j).attack < info.get(i).attack) {
                    sum += info.get(j).attack;
                    // a = 10 a = 20 a = 30 처럼 이전단계 같은팀이 여러명일 수 있기때문에 getOrDefault
                    map.put(info.get(j).team, map.getOrDefault(info.get(j).team, 0) + info.get(j).attack);
                } else {
                    break;
                }
            }
            answer[info.get(i).idx] = sum - map.getOrDefault(info.get(i).team, 0);
        }
        return answer;
    }
}
