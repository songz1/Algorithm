/*
송지은_백준 알고리즘 3568번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_3568 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int idx = 0;
        HashMap<Integer, String> iSharp = new HashMap<>();
        while (stringTokenizer.hasMoreTokens()) {
            iSharp.put(idx++, stringTokenizer.nextToken());
        }

        String result, temp;
        for (int i = 1; i < iSharp.size(); i++) {
            if (iSharp.containsKey(i) && iSharp.get(i).length() != 1) {
                temp = iSharp.get(i);
                temp = temp.substring(0, temp.length() - 1);

                result = "";
                int count = 0;
                for (int j = 0; j < temp.length(); j++) {
                    if (temp.charAt(j) == '[') {
                        result = "[]" + result;
                        j++;
                    } else if (temp.charAt(j) == '&' || temp.charAt(j) == '*') {
                        result = temp.charAt(j) + result;
                    } else {
                        count++;
                    }
                }

                System.out.println(iSharp.get(0) + result + " " + temp.substring(0, count) + ";");
            } else if (iSharp.containsKey(i)) {
                System.out.println(iSharp.get(0) + " ;");
            }
        }
    }
}
