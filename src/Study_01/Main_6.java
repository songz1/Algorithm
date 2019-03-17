/*
송지은_insert(반복문)
*/

package Study_01;

public class Main_6 {
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
        for (int i = a.length-1; i > index; i--) a[i] = a[i - 1];
        a[index] = value;
    }
}
