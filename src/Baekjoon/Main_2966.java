/*
송지은_백준 알고리즘 2966번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main_2966 {
    static int N;
    static String answer;
    static int score;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        answer = bufferedReader.readLine();

        HashMap<String, Integer> scoreMap = new HashMap<>();
        scoreMap.put("Adrian", Adrian());
        scoreMap.put("Bruno", Bruno());
        scoreMap.put("Goran", Goran());

        String[] winner = {"", "", ""};
        int max = Integer.MIN_VALUE;
        int idx = 0;

        for (String s : scoreMap.keySet()) {
            if (max < scoreMap.get(s)) {
                max = scoreMap.get(s);

                idx = 0;
                winner[0] = s;
                winner[1] = "";
                winner[2] = "";
            } else if (max == scoreMap.get(s)) {
                winner[++idx] = s;
            }
        }

        Arrays.sort(winner);

        System.out.println(max);
        for (int i = 0; i < 3; i++) {
            if (!winner[i].equals("")) {
                System.out.println(winner[i]);
            }
        }

    }

    // ABC
    public static int Adrian() {
        score = 0;

        for (int i = 1; i <= N; i++) {
            if (i % 3 == 1) {
                score = answer.charAt(i - 1) == 'A' ? score + 1 : score;
            } else if (i % 3 == 2) {
                score = answer.charAt(i - 1) == 'B' ? score + 1 : score;
            } else if (i % 3 == 0) {
                score = answer.charAt(i - 1) == 'C' ? score + 1 : score;
            }
        }

        return score;
    }

    // BABC
    public static int Bruno() {
        score = 0;

        for (int i = 1; i <= N; i++) {
            if (i % 4 == 1 || i % 4 == 3) {
                score = answer.charAt(i - 1) == 'B' ? score + 1 : score;
            } else if (i % 4 == 2) {
                score = answer.charAt(i - 1) == 'A' ? score + 1 : score;
            } else if (i % 4 == 0) {
                score = answer.charAt(i - 1) == 'C' ? score + 1 : score;
            }
        }

        return score;
    }

    // CCAABB
    public static int Goran() {
        score = 0;

        for (int i = 1; i <= N; i++) {
            if (i % 6 == 1 || i % 6 == 2) {
                score = answer.charAt(i - 1) == 'C' ? score + 1 : score;
            } else if (i % 6 == 3 || i % 6 == 4) {
                score = answer.charAt(i - 1) == 'A' ? score + 1 : score;
            } else if (i % 6 == 5 || i % 6 == 0) {
                score = answer.charAt(i - 1) == 'B' ? score + 1 : score;
            }
        }

        return score;
    }
}
