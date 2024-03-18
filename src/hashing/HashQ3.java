package hashing;

import java.util.*;

/**
 * 서로 다른 빈도수 만들기
 */
public class HashQ3 {

    public static void main(String[] args) {
        HashQ3 q = new HashQ3();
        System.out.println(q.solution("aaabbbcc"));
        System.out.println(q.solution("aaabbc"));
        System.out.println(q.solution("aebbbbc"));
        System.out.println(q.solution("aaabbbcccde"));
        System.out.println(q.solution("aaabbbcccdddeeeeeff"));
    }

    public int solution(String s){
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        Set<Integer> set = new HashSet<>();
        for (int i : map.values()) {
            int value = i;
            while (set.contains(value)) {
                value--;
                answer++;
            }
            if (value != 0) {
                set.add(value);
            }
        }

        return answer;
    }
}
