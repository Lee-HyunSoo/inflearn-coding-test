package baekjoon;

import java.util.*;

public class Q1427 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        String num = String.valueOf(n);

        List<Integer> result = new ArrayList<>();
        for (char c : num.toCharArray()) {
            result.add(Character.getNumericValue(c));
        }
//        Collections.sort(result, Collections.reverseOrder());
        Collections.sort(result, (a, b) -> b - a);

        for (int i : result) {
            System.out.print(i);
        }
    }
}
