package structure;

import java.util.*;

/**
 * 겹쳐진 압축 해제
 */
public class StructureQ2 {

    public static void main(String[] args) {
        StructureQ2 q = new StructureQ2();
        System.out.println(q.solution("3(a2(b))ef"));
        System.out.println(q.solution("2(ab)k3(bc)"));
        System.out.println(q.solution("2(ab3((cd)))"));
        System.out.println(q.solution("2(2(ab)3(2(ac)))"));
        System.out.println(q.solution("3(ab2(sg))"));
    }

    public String solution(String s){
        String answer = "";

        Stack<String> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                String tmp = "";
                while (!st.isEmpty()) {
                    String word = st.pop();
                    if (word.equals("(")) {
                        // 숫자 찾기
                        String num = "";
                        while (!st.isEmpty() && Character.isDigit(st.peek().charAt(0))) {
                            num = st.pop() + num;
                        }

                        int cnt = 1; // 1(문자) 의 경우 1이 생략되기 때문
                        if (!num.equals("")) {
                            cnt = Integer.parseInt(num);
                        }
                        String repeat = tmp.repeat(cnt);
                        st.push(repeat);
                        break;
                    }
                    tmp = word + tmp;
                }
            } else {
                st.push(String.valueOf(c));
            }
        }

        for (String str : st) {
            answer += str;
        }
        return answer;
    }
}
