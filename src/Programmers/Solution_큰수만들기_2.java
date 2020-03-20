/*
송지은_프로그래머스 알고리즘 큰 수 만들기

테스트 10 시간초과 -> String += 연산 대신 StringBuiler 이용
*/

package Programmers;

public class Solution_큰수만들기_2 {
    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
        System.out.println(solution("1231234", 3));
        System.out.println(solution("4177252841", 4));
        System.out.println(solution("9876", 1));
    }

    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int idx = 0;
        int max;

        if (number.charAt(0) == '0') {
            return "0";
        }

        for (int i = 0; i < number.length() - k; i++) {
            max = 0;
            for (int j = idx; j <= k + i; j++) {
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    idx = j + 1;
                }
            }
            answer.append(max);
        }

        return answer.toString();
    }
}
