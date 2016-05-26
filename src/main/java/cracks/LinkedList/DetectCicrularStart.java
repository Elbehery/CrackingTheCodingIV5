package cracks.LinkedList;

import java.util.HashSet;

/**
 * Created by mustafa on 20.03.16.
 */
public class DetectCicrularStart {

    public static Node findStartLoop(Node head) {

        if (head == null)
            throw new IllegalArgumentException();


        HashSet<Integer> lookup = new HashSet<Integer>();

        Node current = head;
        boolean flag = true;

        while (current.next != null && flag) {

            if (lookup.contains(current.next.data))
                flag = false;
            else
                lookup.add(current.next.data);

            current = current.next;
        }

        if (!flag)
            return current;


        return null;
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

        current = head;
        Node loopStart = DetectCicrularStart.findStartLoop(current);
        if (loopStart != null)
            System.out.println(loopStart.data);
    }
}
