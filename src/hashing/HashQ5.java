package hashing;

import java.util.*;

/**
 * 회장 선거
 */
public class HashQ5 {

    public static void main(String[] args) {
        HashQ5 q = new HashQ5();
        System.out.println(q.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(q.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(q.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(q.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
    }

    public String solution(String[] votes, int k) {
        String answer = "";
        Map<String, Set<String>> vote = new HashMap<>();
        Map<String, Integer> candidate = new HashMap<>();

        for (String s : votes) {
            String[] split = s.split(" ");
            vote.putIfAbsent(split[0], new HashSet<>());
            vote.get(split[0]).add(split[1]);
            candidate.put(split[1], candidate.getOrDefault(split[1], 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        Map<String, Integer> present = new HashMap<>();
        for (Map.Entry<String, Set<String>> entry : vote.entrySet()) {
            for (String s : entry.getValue()) {
                if (candidate.get(s) >= k) {
                    present.put(entry.getKey(), present.getOrDefault(entry.getKey(), 0) + 1);
                }
            }
            max = Math.max(max, present.get(entry.getKey()));
        }

        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : present.entrySet()) {
            if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }

//        list.sort((a, b) -> a.compareTo(b));
        Collections.sort(list);
        answer = list.getFirst();

        return answer;
    }
}
