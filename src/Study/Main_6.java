/*
송지은_insert
*/

package Study;

public class Main_6 {
    public static void main(String[] args) {
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) a[i] = i;
        a = insert(a, 5, -99);
        print(a);
    }

    static void print(int[] a) {
        for (int i : a) System.out.print(i + " ");
    }

    static int[] insert(int[] a, int index, int value) {
        int[] temp = new int[a.length];
        for (int i = 0; i < index; i++) temp[i] = a[i];

        temp[index] = value;
        for (int i = index + 1; i < temp.length; i++) temp[i] = a[i - 1];

        return temp;
    }
}
