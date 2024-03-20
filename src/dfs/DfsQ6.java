package dfs;

import java.util.*;

/**
 * 알파코드
 */
public class DfsQ6 {

    public static void main(String[] args) {
        DfsQ6 q = new DfsQ6();
        System.out.println(q.solution("25114"));
        System.out.println(q.solution("23251232"));
        System.out.println(q.solution("21020132"));
        System.out.println(q.solution("21350"));
        System.out.println(q.solution("120225"));
        System.out.println(q.solution("232012521"));
    }

    static Deque<String> deque;
    static List<String> result;
    static int answer;

    public int solution(String s){
        answer = 0;
        deque = new LinkedList<>();


        dfs(0, s);

        return answer;
    }

    public void dfs(int start, String s) {
        if (start == s.length()) {
            answer++;
        } else {
            for (int i = start; i < s.length(); i++) {
                if (s.charAt(start) == '0' && i > start) {
                    return;
                }

                String num = s.substring(start, i + 1);
                if (Integer.parseInt(num) > 26) {
                    return;
                }

                deque.add(num);
                dfs(i + 1, s);
                deque.pollLast();
            }
        }
    }
}
