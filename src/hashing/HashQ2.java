package hashing;

import java.util.*;

/**
 * 같은 빈도수 만들기
 */
public class HashQ2 {

    public static void main(String[] args) {
        HashQ2 q = new HashQ2();
        System.out.println(Arrays.toString(q.solution("aaabc")));
        System.out.println(Arrays.toString(q.solution("aabb")));
        System.out.println(Arrays.toString(q.solution("abcde")));
        System.out.println(Arrays.toString(q.solution("abcdeabc")));
        System.out.println(Arrays.toString(q.solution("abbccddee")));
    }

    public int[] solution(String s){
        int[] answer = new int[5];
        Map<Character, Integer> map = new HashMap<>();
        for (char c = 'a'; c <= 'e'; c++) {
            map.put(c, 0);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            max = Math.max(max, map.get(s.charAt(i)));
        }

        int idx = 0;
        for (char c = 'a'; c <= 'e'; c++) {
            answer[idx++] = max - map.get(c);
        }

        return answer;
    }
}
