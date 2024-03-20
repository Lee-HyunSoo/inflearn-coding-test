package dfs;

import java.util.*;

/**
 * 팰린드롬의 경우수
 */
public class DfsQ4 {

    public static void main(String[] args) {
        DfsQ4 q = new DfsQ4();
        System.out.println(Arrays.toString(q.solution("aaaabb")));
        System.out.println(Arrays.toString(q.solution("abbcc")));
        System.out.println(Arrays.toString(q.solution("abbccee")));
        System.out.println(Arrays.toString(q.solution("abbcceee")));
        System.out.println(Arrays.toString(q.solution("ffeffaae")));
    }

    static Map<Character, Integer> map;
    static Deque<Character> deque;
    static List<String> result;

    public String[] solution(String s){
        String[] answer;
        map = new HashMap<>();
        deque = new LinkedList<>();
        result = new ArrayList<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int odd = 0;
        char mid = '#';
        for (char key : map.keySet()) {
            if (map.get(key) % 2 != 0) {
                mid = key;
                odd++;
            }
        }

        // 팰린드롬은 홀수개 문자 개수가 2개 이상이면 만들어지지 않는다.
        if (odd > 1) {
            return new String[]{};
        }
        if (mid != '#') {
            deque.add(mid);
            map.put(mid, map.get(mid) - 1); // 하나 썼으니 하나 줄여준다.
        }
        dfs(s);
        answer = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    public void dfs(String s) {
        if (deque.size() == s.length()) {
            String res = "";
            for (char c : deque) {
                res += c;
            }
            result.add(res);
        } else {
            for (char key : map.keySet()) {
                if (map.get(key) == 0) {
                    continue;
                }
                deque.addFirst(key);
                deque.addLast(key);
                map.put(key, map.get(key) - 2);
                dfs(s);
                deque.pollFirst();
                deque.pollLast();
                map.put(key, map.get(key) + 2);
            }
        }
    }
}
