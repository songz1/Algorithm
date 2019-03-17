/*
송지은_remove(반복문)
*/

package Study_01;

public class Main_7 {
    public static void main(String[] args) {
        int[] a = new int[10];
        for (int i = 0; i < a.length; ++i) a[i] = i;
        remove(a, 5);
        print(a);
    }

    static void print(int[] a) {
        for (int i : a) System.out.printf("%d ", i);
    }

    static void remove(int[] a, int index) {
        for(int i=index; i<a.length-1; i++) a[i] = a[i+1];
        a[a.length-1] = 0;
    }
}
