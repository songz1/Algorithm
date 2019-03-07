/*
송지은_10 9 8 7 6 5 4 3 2 1 출력(재귀)
*/

package Study;

public class Main_4 {
    public static void main(String[] args) {
        Node root = null;
        for (int i = 1; i <= 10; i++)
            root = new Node(i, root);
        root.printAll(root);
    }

    static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public void printAll(Node root) {
            if (root.next == null) {
                System.out.print(root.value);
                return;
            }
            System.out.print(root.value + " ");
            root = root.next;
            printAll(root);
        }
    }
}
