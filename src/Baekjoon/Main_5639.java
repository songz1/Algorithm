/*
송지은_백준 알고리즘 5639번
*/

package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_5639 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BinaryTree binaryTree = new BinaryTree();

        String s = "";
        while ((s = bufferedReader.readLine()) != null && s.length() != 0) {
            binaryTree.add(Integer.parseInt(s));
        }

        binaryTree.print();
    }

    public static class Node {
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
            if (this.right != null) this.right.print();
            System.out.print(this.value + " ");
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
    }
}
