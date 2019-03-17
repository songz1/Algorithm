/*
송지은_insert(재귀)
*/

package Study_01;

public class Main_6_1 {
    public static void main(String[] args) {
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) a[i] = i;
        insert(a, 5, -99);
        print(a);
    }

    static void print(int[] a) {
        for (int i : a) System.out.print(i + " ");
    }

    static void insert(int[] a, int index, int value) {
        if (index >= a.length) return;
        insert(a, index + 1, a[index]);
        a[index] = value;
    }
}
