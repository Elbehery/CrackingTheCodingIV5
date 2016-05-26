package cracks.LinkedList;

/**
 * Created by mustafa on 20.03.16.
 */
public class PartitionNodeAroundElement {

    public static Node partitionAroundElement(Node head, int pivot) {

        if (head == null)
            throw new IllegalArgumentException();

        Node beforeListHead = null;
        Node beforeListTail = null;
        Node afterListHead = null;
        Node afterListTail = null;

        Node current = head;
        while (current != null) {

            // less list
            if (current.data < pivot) {
                if (beforeListHead == null) {
                    beforeListHead = current;
                    beforeListTail = beforeListHead;
                } else {
                    beforeListTail.next = current;
                    beforeListTail = current;
                }
            }
            // greate or equal list
            else if (current.data >= pivot) {

                if (afterListHead == null) {
                    afterListHead = current;
                    afterListTail = afterListHead;
                } else {

                    afterListTail.next = current;
                    afterListTail = current;

                }
            }

            current = current.next;
        }

        beforeListTail.next = afterListHead;

        return beforeListHead;

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
        Node newHead = PartitionNodeAroundElement.partitionAroundElement(head, 4);


        current = newHead;
        while (current.next != null) {
            System.out.print(current.next.data + "-->");
            current = current.next;
        }


    }
}
