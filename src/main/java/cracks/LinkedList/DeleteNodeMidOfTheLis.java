package cracks.LinkedList;

/**
 * Created by mustafa on 20.03.16.
 */
public class DeleteNodeMidOfTheLis {

    public static boolean deleteNodeMidOfTheList(Node target) {

        if (target == null)
            throw new IllegalArgumentException();

        Node next = target.next;
        if (next == null)
            return false;

        target.data = next.data;
        // deletion
        target.next = next.next;
        next.next = null;


        return true;
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
        System.out.println(DeleteNodeMidOfTheLis.deleteNodeMidOfTheList(head.next.next.next.next.next.next.next.next));

         current = head;
        while (current.next != null) {
            System.out.print(current.next.data + "-->");
            current = current.next;
        }
    }
}
