/*
송지은_0 1 2 3 4 5 6 7 8 9 10 출력(재귀)
*/

package Study;

public class Main_5 {
    public static void main(String[] args) {
        Node root = new Node(0, null);
        Node tail = root;
        for (int i = 1; i <= 10; ++i) {
            tail.addTail(i);
            tail = tail.next;
        }
        root.printAll();
    }

    static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public void printAll() {
            if(next != null) {
                System.out.print(value + " ");
                next.printAll();
            }
            else System.out.print(value);
        }

        public void addTail(int value) {
            if (next != null) next.addTail(value);
            else next = new Node(value, null);
        }
    }
}
