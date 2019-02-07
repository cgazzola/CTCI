package LinkedLists;

public class Node {

    Node next = null;
    int data;

    public Node(int d) {
        data = d;
    }

    void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    void deleteNode(int d) {
        Node prev = this;
        Node curr = this;
        while (curr.data != d) {
            prev = curr;
            curr = curr.next;
        }

        prev.next = curr.next;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.appendToTail(2);
        head.appendToTail(3);
        head.appendToTail(4);
        head.appendToTail(5);
        head.appendToTail(6);

        Node pointer = head;
        while (pointer != null) {
            System.out.print(pointer.data + " -> ");
            pointer = pointer.next;
        }

        System.out.println();

        head.deleteNode(1);
        Node pointer2 = head;

        while (pointer2 != null) {
            System.out.print(pointer2.data + " -> ");
            pointer2 = pointer2.next;
        }
    }
}
