/*
송지은_삽입 정렬(insertion sort)
*/

package Study;

import java.util.Arrays;

public class Main_15 {
    public static void main(String[] args) {
        int[] a = {17, 14, 11, 19, 13, 15};
        insertionSort(a);
        System.out.println(Arrays.toString(a));
    }

    static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int value = a[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (value < a[j]) {
                    a[i] = a[j];
                } else break;
            }
            a[j + 1] = value;
        }
    }
}
