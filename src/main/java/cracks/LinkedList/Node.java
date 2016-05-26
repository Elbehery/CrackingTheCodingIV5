package cracks.LinkedList;

/**
 * Created by mustafa on 19.03.16.
 */
public class Node {

    public Node next = null;
    public int data;

    public Node(int data) {
        this.data = data;
    }


    public void appendToTail(int data) {

        Node newNode = new Node(data);
        Node current = this;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;

    }

    Node deleteNode(Node head, int data) {

        if (head.data == data) {
            head = head.next;
            return head;
        }

        Node current = head;

        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return head;
            }

            current = current.next;

        }

        return head;
    }
}
