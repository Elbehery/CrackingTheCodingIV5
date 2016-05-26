package cracking2;

/**
 * Created by mustafa on 06.04.16.
 */
public class Stack {

    public LinkedListNode top;

    public Stack(Integer data) {
        top = new LinkedListNode(data);
    }

    public Integer pop() {
        if (top != null) {
            int item = top.data;
            top = top.next;
            return item;
        }

        return null;
    }

    public void push(int data) {

        LinkedListNode newNode = new LinkedListNode(data);
        newNode.next = top;
        top = newNode;
    }

    public Integer peek() {
        if (top != null)
            return top.data;

        return null;
    }

}
