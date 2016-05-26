package cracking2;

/**
 * Created by mustafa on 06.04.16.
 */
public class Queue {

    public LinkedListNode head, tail;

    public Queue() {
        head = null;
        tail = null;
    }

    public Queue(int data) {
        head = new LinkedListNode(data);
        tail = head;
    }

    public void enqueue(int item) {
        LinkedListNode newNode = new LinkedListNode(item);
        if (tail == null) {
            tail = newNode;
            head = tail;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public Integer dequeue() {

        if (head != null) {
            int item = head.data;
            head = head.next;
            return item;
        }

        return null;
    }

}
