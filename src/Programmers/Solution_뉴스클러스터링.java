/*
송지은_프로그래머스 알고리즘 뉴스 클러스터링
*/

package Programmers;

import java.util.ArrayList;

public class Solution_뉴스클러스터링 {
    public static void main(String[] args) {
        System.out.println(solution("FRANCE", "french"));
        System.out.println(solution("handshake", "shake hands"));
        System.out.println(solution("aa1+aa2", "AAAA12"));
        System.out.println(solution("E=M*C^2", "e=m*c^2"));
    }

    public static int solution(String str1, String str2) {
        if (str1.length() < 2 && str2.length() < 2) {
            return 65536;
        }

        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        ArrayList<String> a = new ArrayList<>();
        ArrayList<String> b = new ArrayList<>();

        String s;

        for (int i = 0; i < str1.length() - 1; i++) {
            s = str1.substring(i, i + 2);

            if ((65 <= s.charAt(0) && s.charAt(0) <= 90) && (65 <= s.charAt(1) && s.charAt(1) <= 90)) {
                a.add(s);
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            s = str2.substring(i, i + 2);

            if ((65 <= s.charAt(0) && s.charAt(0) <= 90) && (65 <= s.charAt(1) && s.charAt(1) <= 90)) {
                b.add(s);
            }
        }

        if (a.isEmpty() && b.isEmpty()) {
            return 65536;
        }

        double union = a.size() + b.size();
        double intersection = 0;

        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < b.size(); j++) {
                if (a.get(i).equals(b.get(j))) {
                    intersection++;
                    a.remove(i);
                    b.remove(j);
                    i--;
                    break;
                }
            }
        }

        union = union - intersection;
        double result = intersection / union * 65536;
        int answer = (int) result;

        return answer;
    }
}
