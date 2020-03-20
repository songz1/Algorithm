/*
송지은_프로그래머스 알고리즘 큰 수 만들기

테스트 10 시간초과
*/

package Programmers;

import java.util.ArrayList;

public class Solution_큰수만들기 {
    public static void main(String[] atgs) {
        System.out.println(solution("1924", 2));
        System.out.println(solution("1231234", 3));
        System.out.println(solution("4177252841", 4));
        System.out.println(solution("9999999999", 4));
    }

    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int count = number.length() - k;

        ArrayList<Integer> num = new ArrayList();
        for (int n : number.toCharArray()) {
            num.add(n - '0');
        }
        num.add(-1);

        while (k > 0) {
            for (int i = 0; i < number.length(); i++) {
                if (num.get(i + 1) < 0 && k > 0) {
                    k = -1;
                    break;
                }

                if (num.get(i + 1) >= 0 && num.get(i) < num.get(i + 1)) {
                    num.remove(i);
                    k--;
                    break;
                }
            }
        }

        for (int i = 0; i < count; i++) {
            answer.append(num.get(i));
        }

        return answer.toString();
    }
}
