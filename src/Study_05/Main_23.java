/*
송지은_이진 트리(binary tree)_dummy 미사용
*/

package Study_05;

public class Main_23 {
    public static void main(String[] args) {
        int[] a = {5, 18, 1, 12, 7, 2, 14, 6, 9, 15};
        BinaryTree binaryTree = new BinaryTree();
        for (int i = 0; i < a.length; ++i) binaryTree.add(a[i]);
        binaryTree.print();
        binaryTree.remove(14);
        binaryTree.remove(15);
        binaryTree.remove(5);
        binaryTree.remove(10);
        binaryTree.print();
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
            return true;
        }

        public int getLeftMostValue() {
            if (left != null) return left.getLeftMostValue();
            return value;
        }

        public void remove(int value, Node parent) {
            if (value < this.value) {
                if (left != null) left.remove(value, this);
            } else if (value > this.value) {
                if (right != null) right.remove(value, this);
            } else {
                if (left != null && right != null) {
                    int temp = right.getLeftMostValue();
                    this.value = temp;
                    right.remove(temp, this);
                } else {
                    Node temp = (left != null) ? left : right;
                    if (this == parent.left) parent.left = temp;
                    else if (this == parent.right) parent.right = temp;
                }
            }
        }
    }

    static class BinaryTree {
        Node root;

        public void add(int value) {
            if (root != null) root.add(value);
            else root = new Node(value);
        }

        public void print() {
            if (root != null) root.print();
            System.out.println();
        }

        public boolean contains(int value) {
            if (root != null) return root.contains(value);
            return false;
        }

        public void remove(int value) {
            if (root == null) return;
            else if (root.value == value) {
                if (root.left != null && root.right != null) {
                    int temp = root.right.getLeftMostValue();
                    root.value = temp;
                    root.right.remove(temp, root);
                } else {
                    Node temp = (root.left != null) ? root.left : root.right;
                    root = temp;
                }
            } else root.remove(value, null);
        }
    }
}
