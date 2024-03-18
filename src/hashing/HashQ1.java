package hashing;

import java.util.*;

/**
 * 한 번만 사용한 최초 문자
 */
public class HashQ1 {

    public static void main(String[] args) {
        HashQ1 q = new HashQ1();
        System.out.println(q.solution("statitsics"));
        System.out.println(q.solution("aabb"));
        System.out.println(q.solution("stringshowtime"));
        System.out.println(q.solution("abcdeabcdfg"));
    }

    public int solution(String s){
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i + 1;
            }
        }
        return -1;
    }
}
