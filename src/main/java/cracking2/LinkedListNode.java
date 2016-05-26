package cracking2;

/**
 * Created by mustafa on 06.04.16.
 */
public class LinkedListNode {

    public Integer data;
    public LinkedListNode next;

    public LinkedListNode(Integer t) {
        data = t;
    }

    public void addToTail(LinkedListNode head, int data) {

        LinkedListNode newNode = new LinkedListNode(data);

        LinkedListNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }


    public LinkedListNode deleteFromList(LinkedListNode head, int d) {

        LinkedListNode current = head;

        // special case
        if (current.data == d) {
            head = head.next;
            return head;
        }

        while (current.next != null) {
            if (current.next.data == d) {
                current.next = current.next.next;
                return head;
            }

            // move the cursor
            current = current.next;
        }

        return head;
    }
}
