/*
송지은_백준 알고리즘 11723번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_11723 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder("");
        StringTokenizer stringTokenizer;

        Set<String> S = new HashSet<>();
        int M = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            switch (stringTokenizer.nextToken()) {
                case "add":
                    S.add(stringTokenizer.nextToken());
                    break;
                case "remove":
                    S.remove(stringTokenizer.nextToken());
                    break;
                case "check":
                    if (S.contains(stringTokenizer.nextToken())) {
                        stringBuilder.append(1 + "\n");
                    } else {
                        stringBuilder.append(0 + "\n");
                    }
                    break;
                case "toggle":
                    String temp = stringTokenizer.nextToken();
                    if (S.contains(temp)) {
                        S.remove(temp);
                    } else {
                        S.add(temp);
                    }
                    break;
                case "all":
                    S.clear();
                    for (int j = 1; j <= 20; j++) {
                        S.add("" + j);
                    }
                    break;
                case "empty":
                    S.clear();
                    break;
            }
        }

        System.out.print(stringBuilder.toString());
    }
}
