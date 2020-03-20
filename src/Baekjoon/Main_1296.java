/*
송지은_백준 알고리즘 1296번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_1296 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String men = bufferedReader.readLine();

        int[] menLove = new int[4];
        for (int i = 0; i < men.length(); i++) {
            char c = men.charAt(i);

            if (c == 'L') {
                menLove[0] += 1;
            } else if (c == 'O') {
                menLove[1] += 1;
            } else if (c == 'V') {
                menLove[2] += 1;
            } else if (c == 'E') {
                menLove[3] += 1;
            }
        }

        int N = Integer.parseInt(bufferedReader.readLine());
        HashMap<String, Integer> per = new HashMap<>();

        String womyn;
        int[] womynLove = new int[4];
        for (int i = 0; i < N; i++) {
            womyn = bufferedReader.readLine();

            womynLove[0] = menLove[0];
            womynLove[1] = menLove[1];
            womynLove[2] = menLove[2];
            womynLove[3] = menLove[3];

            for (int j = 0; j < womyn.length(); j++) {
                char c = womyn.charAt(j);

                if (c == 'L') {
                    womynLove[0] += 1;
                } else if (c == 'O') {
                    womynLove[1] += 1;
                } else if (c == 'V') {
                    womynLove[2] += 1;
                } else if (c == 'E') {
                    womynLove[3] += 1;
                }
            }

            per.put(womyn, ((womynLove[0] + womynLove[1]) * (womynLove[0] + womynLove[2]) * (womynLove[0] + womynLove[3]) * (womynLove[1] + womynLove[2]) * (womynLove[1] + womynLove[3]) * (womynLove[2] + womynLove[3])) % 100);
        }

        int max = Integer.MIN_VALUE;
        String result = "a";
        for (String s : per.keySet()) {
            if (max < per.get(s)) {
                max = per.get(s);
                result = s;
            } else if (max == per.get(s)) {
                if (result.compareTo(s) > 0) {
                    result = s;
                }
            }
        }

        System.out.print(result);
    }
}
