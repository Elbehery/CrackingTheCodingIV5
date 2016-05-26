package cracks.LinkedList;

/**
 * Created by mustafa on 20.03.16.
 */
public class DeleteKthLastElement {

    public static Node findKthLastElement(Node head, int k) {

        if (head == null)
            throw new IllegalArgumentException();

        int listLength = 0;
        Node current = head;

        while (current.next != null) {
            listLength++;
            current = current.next;
        }

        System.out.println("************ " + listLength);

        int i = 0;
        current = head;
        while (current.next != null && i < (listLength - k)) {
            i++;
            current = current.next;
        }

        return current.next;

    }


    public static int findKthLastElementRecursively(Node head, int k) {

        if (head == null)
            return 0;


        int positionInList = findKthLastElementRecursively(head.next, k) + 1;
        if (positionInList == k) {
            System.out.println(head.data);
        }

        return positionInList;
    }


    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node twoRep = new Node(2);
        Node threeRep = new Node(3);
        Node fourRep = new Node(4);
        Node five = new Node(5);

        Node head = new Node(0);

        // link the nodes
        head.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = twoRep;
        twoRep.next = threeRep;
        threeRep.next = fourRep;
        fourRep.next = five;
        five.next = null;


        Node current = head;
        while (current.next != null) {
            System.out.print(current.next.data + "-->");
            current = current.next;
        }

        System.out.println();
        DeleteKthLastElement.findKthLastElementRecursively(head, 4);
        //System.out.println(kth.data);
    }
}
