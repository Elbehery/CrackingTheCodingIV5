package cracks.Stack;

import cracks.LinkedList.Node;

/**
 * Created by mustafa on 20.03.16.
 */
public class Stack {

    Node top;
    int capacity;
    int size;

    public Stack() {

        capacity = 10;
    }

    public Stack(int capacity) {
        this.capacity = capacity;
        this.size = capacity;
    }

    public Integer pop() {

        if (!isEmpty() && top != null) {
            int item = top.data;
            top = top.next;
            size++;
            return item;
        }

        return null;
    }

    public void push(Integer item) {


        if (!isFull()) {
            Node newNode = new Node(item);
            newNode.next = top;
            top = newNode;
            size--;
        }

    }


    public Integer peek() {

        return top.data;

    }

    public boolean isFull() {
        return size == 0;
    }

    public boolean isEmpty() {
        return size == capacity;
    }
}
