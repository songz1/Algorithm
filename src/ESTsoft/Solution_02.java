package ESTsoft;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution_02 {
    public static void main(String[] args) {
    }

    public int solution(int[] A) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        ArrayList<Integer>[] list = new ArrayList[A.length];

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        String temp;
        int sum;
        for (int i = 0; i < A.length; i++) {
            temp = "" + A[i];
            sum = 0;

            for (int j = 0; j < temp.length(); j++) {
                sum += temp.charAt(j) - '0';
            }

            if (hashMap.containsKey(sum)) {
                list[hashMap.get(sum)].add(i);
            } else {
                list[i].add(i);
                hashMap.put(sum, i);
            }
        }

        if (hashMap.size() == A.length) {
            return -1;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].size() - 1; j++) {
                for (int k = j + 1; k < list[i].size(); k++) {
                    int a = A[list[i].get(j)] + A[list[i].get(k)];
                    max = max < a ? a : max;
                }
            }
        }

        return max;
    }
}
