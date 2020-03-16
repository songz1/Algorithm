/*
송지은_백준 알고리즘 7785번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_7785 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        HashSet<String> people = new HashSet<>();
        StringTokenizer stringTokenizer;
        String person, state;

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            person = stringTokenizer.nextToken();
            state = stringTokenizer.nextToken();

            if (state.equals("enter")) {
                people.add(person);
            } else {
                people.remove(person);
            }
        }

        int idx = 0;
        String[] result = new String[people.size()];
        for (String s : people) {
            result[idx++] = s;
        }

        Arrays.sort(result);

        for (int i = result.length - 1; i >= 0; i--) {
            System.out.println(result[i]);
        }
    }
}
