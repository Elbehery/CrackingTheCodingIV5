package cracks.LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mustafa on 19.03.16.
 */
public class RemovingDuplicates {

    public static void deleteDuplicates(Node head) {

        // lookup
        Set<Integer> lookup = new HashSet<Integer>();

        Node current = head;

        while (current.next != null) {
            // search if it is duplicate
            if (lookup.contains(current.next.data)) {
                current.next = current.next.next;
            } else {
                lookup.add(current.next.data);
                current = current.next;
            }
        }

    }


    public static void deleteDuplicatesWithoutLookup(Node head) {

        if (head == null || head.next == null)
            return;

        Node runner, current = head;

        while (current != null) {

            // re initialize for the new current node
            runner = current;

            // search by runner only
            while (runner.next != null) {

                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else
                    runner = runner.next;

            }

            current = current.next;

        }

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

        RemovingDuplicates.deleteDuplicatesWithoutLookup(head);
        System.out.println();

        current = head;
        while (current.next != null) {
            System.out.print(current.next.data + "-->");
            current = current.next;
        }


    }
}
