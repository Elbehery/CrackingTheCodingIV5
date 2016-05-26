package cracks.Queue;

import cracks.LinkedList.Node;

/**
 * Created by mustafa on 20.03.16.
 */
public class Queue {

    Node first, last;

    public void enqueue(Integer item) {

        if (first == null) {
            last = new Node(item);
            first = last;
        } else {
            last.next = new Node(item);
            last = last.next;
        }

    }


    public Integer dequeue() {

        if (first != null) {
            Integer item = first.data;
            first = first.next;
            if (first == null)
                first = last;

            return item;
        }

        return null;
    }
}
