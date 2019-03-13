/*
송지은_배열 선형 탐색, 배열 이진 탐색, 배열 이진 탐색(재귀)
*/

package Study;

import java.util.Arrays;
import java.util.Random;

public class Main_9 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] a = new int[10];
        for (int i = 0; i < a.length; ++i) a[i] = random.nextInt(20);
        sort(a);
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < 30; ++i) {
            int value = random.nextInt(20);
            int i1 = search1(a, value);  // 배열 선형 탐색
            int i2 = search2(a, value);  // 배열 이진 탐색
            int i3 = search3(a, value);  // 배열 이진 탐색(재귀)
            if ((i1 == -1 && i2 == -1 && i3 == -1) || (value == a[i1] && value == a[i2] && value == a[i3])) {
                System.out.printf("Ok: value=%d, i1=%d, i2=%d i3=%d\n", value, i1, i2, i3);
            } else {
                System.out.printf("Error: value=%d, i1=%d, i2=%d i3=%d\n", value, i1, i2, i3);
                break;
            }
        }
        System.out.println("done");
    }

    static void swap(int[] a, int i, int j) {
        int t = a[j];
        a[j] = a[i];
        a[i] = t;
    }

    static void sort(int[] a) {
        for (int i = 0; i < a.length - 1; ++i)
            for (int j = i + 1; j < a.length; ++j)
                if (a[i] > a[j]) swap(a, i, j);
    }

    static int search1(int[] a, int value) {
        for (int i = 0; i < a.length; ++i)
            if (a[i] == value) return i;
        return -1;
    }

    static int search2(int[] a, int value) {
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (a[middle] < value) start = middle + 1;
            else if (a[middle] > value) end = middle - 1;
            else return middle;
        }
        return -1;
    }

    static int search3(int[] a, int value) {
        return search3(a, value, 0, a.length - 1);
    }

    static int search3(int[] a, int value, int start, int end) {
        if (start > end) return -1;
        int middle = (start + end) / 2;
        if (a[middle] < value) start = middle + 1;
        else if (a[middle] > value) end = middle - 1;
        else return middle;
        return search3(a, value, start, end);
    }
}

