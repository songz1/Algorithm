/*
송지은_트리 탐색
*/

package Study_01;

import java.util.ArrayList;
import java.util.List;

class Node {
    List<Node> children;
    int value;

    public Node(int value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public void addChild(Node child) {
        this.children.add(child);
    }

    public boolean contains(int value) {
        if (this.value == value) return true;
        for (Node temp : this.children)
            if (temp.contains(value)) return true;

        return false;
    }
}

public class Main_8 {
    public static void main(String[] args) {
        Node node1 = new Node(10);
        node1.addChild(new Node(15));
        Node node2 = new Node(17);
        node2.addChild(new Node(18));
        node2.addChild(new Node(16));
        Node node3 = new Node(25);
        node3.addChild(new Node(3));
        node3.addChild(node1);
        node3.addChild(node2);
        Node node4 = new Node(30);
        node4.addChild(new Node(4));
        Node root = new Node(5);
        root.addChild(node3);
        root.addChild(node4);
        System.out.println(root.contains(15));
        System.out.println(root.contains(4));
        System.out.println(root.contains(40));
    }

}
