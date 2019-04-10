/*
송지은_이진 트리(binary tree)_root 노드 삭제 미구현 상태
*/

package Study_05;

public class Main_22_1 {
    public static void main(String[] args) {
        int[] a = {5, 18, 1, 12, 7, 2, 14, 6, 9, 15};
        Node root = new Node(10);
        for (int i = 0; i < a.length; ++i) root.add(a[i]);
        root.print();
        System.out.println();
    }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public void add(int value) {
            if (this.value < value) {
                if (right == null) right = new Node(value);
                else right.add(value);
            } else if (this.value > value) {
                if (left == null) left = new Node(value);
                else left.add(value);
            } else return;
        }

        public void print() {
            if (this.left != null) this.left.print();
            System.out.print(this.value + " ");
            if (this.right != null) this.right.print();
        }

        public boolean contains(int value) {
            if (value < this.value) return left != null && left.contains(value);
            else if (value > this.value) return right != null && right.contains(value);
            return true; // (value == this.value)인 경우 return true;
        }

        public int getLeftMostValue() {
            if(left != null) return left.getLeftMostValue();
            return value;
        }

        public void remove(int value, Node parent) {
            if (value < this.value) {
                if(left != null) remove(value, this);
            } else if (value > this.value) {
                if(right != null) remove(value, this);
            } else {
                // 자식이 없는 경우 (지워도 무방한 코드)
                if(left == null && right == null){
                    if(this == parent.left) parent.left = null;
                    else if(this == parent.right) parent.right = null;
                }
                // 자식이 하나만 있는 경우
                else if(left == null || right == null){
                    Node temp = (left != null)? left:right;
                    if(this == parent.left) parent.left = temp;
                    else if(this == parent.right) parent.right = temp;
                }
                // 자식이 둘 다 있는 경우
                else {
                    int temp = right.getLeftMostValue();
                    this.value = temp;
                    right.remove(temp, this);
                }
            }
        }
    }
}


