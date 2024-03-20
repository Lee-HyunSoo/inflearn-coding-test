package dfs;

import java.util.*;

/**
 * IP 주소
 */
public class DfsQ5 {

    public static void main(String[] args) {
        DfsQ5 q = new DfsQ5();
        System.out.println(Arrays.toString(q.solution("2025505")));
        System.out.println(Arrays.toString(q.solution("0000")));
        System.out.println(Arrays.toString(q.solution("255003")));
        System.out.println(Arrays.toString(q.solution("155032012")));
        System.out.println(Arrays.toString(q.solution("02325123")));
        System.out.println(Arrays.toString(q.solution("121431211")));
    }
    static Deque<String> deque;
    static List<String> result;

    public String[] solution(String s){
        String[] answer;

        deque = new LinkedList<>();
        result = new ArrayList<>();

        dfs(0, s);

        answer = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    public void dfs(int start, String s) {
        if (start == s.length() && deque.size() == 4) {
            String str = "";
            for (String st : deque) {
                str += st + ".";
            }
            result.add(str.substring(0, str.length() - 1)); // 마지막 . 을 떼기 위해
        }

        for (int i = start; i < s.length(); i++) {
            if (s.charAt(start) == '0' && i > start) {
                return;
            }

            String num = s.substring(start, i + 1);
            if (Integer.parseInt(num) > 255) {
                return;
            }

            deque.add(num);
            dfs(i + 1, s);
            deque.pollLast();
        }
    }
}
