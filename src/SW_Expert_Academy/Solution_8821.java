/*
송지은_SW 알고리즘 8821번
*/

package SW_Expert_Academy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution_8821 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 1; i <= T; i++) {
            String s = bufferedReader.readLine();
            HashSet<Character> set = new HashSet();

            for (char c : s.toCharArray()) {
                if (set.contains(c)) {
                    set.remove(c);
                } else {
                    set.add(c);
                }
            }

            System.out.println("#" + i + " " + set.size());
        }
    }
}
