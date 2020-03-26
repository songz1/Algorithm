/*
송지은_백준 알고리즘 4641번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_4641 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int count = 0;
            ArrayList<Integer> list = new ArrayList<>();
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            while (stringTokenizer.hasMoreTokens()) {
                list.add(Integer.parseInt(stringTokenizer.nextToken()));
            }

            if (list.get(0).equals(-1)) {
                return;
            }

            Collections.sort(list);

            for (int i = 1; i < list.size() - 1; i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    count = list.get(i) * 2 == list.get(j) ? count + 1 : count;
                }
            }

            System.out.println(count);
        }
    }
}
