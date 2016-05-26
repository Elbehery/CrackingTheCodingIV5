package cracking2;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by mustafa on 06.04.16.
 */
public class LinkedLists {

    public static LinkedListNode removeDuplicatesFromLinkedList(LinkedListNode head) {

        if (head == null || head.next == null)
            return head;

        LinkedListNode current = head;
        Set<Integer> duplicatesHashSet = new HashSet<>();
        duplicatesHashSet.add(current.data);

        while (current.next != null) {

            if (duplicatesHashSet.contains(current.next.data)) {
                current.next = current.next.next;
            } else {
                duplicatesHashSet.add(current.next.data);
                current = current.next;
            }
        }

        return head;
    }

    public static LinkedListNode removeDuplicatedWithoutBufferQuadratic(LinkedListNode head) {

        if (head == null || head.next == null)
            return head;

        LinkedListNode runner, current = head;


        while (current.next != null) {

            runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else
                    runner = runner.next;
            }
            current = current.next;
        }

        return head;
    }

    public static LinkedList removeDuplicatedWithoutBufferLinearithmic(LinkedList<Integer> linkedList) {

        if (linkedList == null)
            throw new NullPointerException();

        if (linkedList.size() == 1)
            return linkedList;

        if (linkedList.size() < 1)
            throw new IllegalArgumentException();


        Collections.sort(linkedList);

        int lastCheckedElement = linkedList.get(0);

        for (int i = 1; i < linkedList.size(); ) {
            if (linkedList.get(i) == lastCheckedElement) {
                linkedList.remove(i);
            } else {
                lastCheckedElement = linkedList.get(i);
                i++;
            }
        }

        return linkedList;
    }

    public static int returnKthElementInLinkedList(LinkedListNode head, int k) {

        if (head == null) {
            return 0;
        }

        int index = returnKthElementInLinkedList(head.next, k) + 1;
        if (index == k)
            System.out.println("*** " + head.data);

        return index;

    }

    public static LinkedListNode partitionElementsAroundValue(LinkedListNode head, int x) {

        if (head == null || head.next == null)
            return head;


        LinkedListNode lessHead = null;
        LinkedListNode lessTail = null;
        LinkedListNode greaterHead = null;
        LinkedListNode greaterTail = null;

        while (head != null) {

            if (head.data < x) {

                if (lessHead == null) {
                    lessHead = new LinkedListNode(head.data);
                    lessTail = lessHead;
                } else {

                    LinkedListNode dummyNode = new LinkedListNode(head.data);
                    lessTail.next = dummyNode;
                    lessTail = dummyNode;
                    dummyNode = null;
                }

            } else if (head.data >= x) {

                if (greaterHead == null) {
                    greaterHead = new LinkedListNode(head.data);
                    greaterTail = greaterHead;
                } else {

                    LinkedListNode dummyNode = new LinkedListNode(head.data);
                    greaterTail.next = dummyNode;
                    greaterTail = dummyNode;
                    dummyNode = null;
                }
            }

            head = head.next;
        }

        if (lessHead == null)
            return greaterHead;

        if (greaterHead == null)
            return lessHead;

        lessTail.next = greaterHead;

        return lessHead;
    }


    public static void main(String[] args) {


        LinkedListNode one = new LinkedListNode(1);
        LinkedListNode two = new LinkedListNode(2);
        LinkedListNode three = new LinkedListNode(3);
        LinkedListNode four = new LinkedListNode(4);
        LinkedListNode twoRep = new LinkedListNode(2);
        LinkedListNode threeRep = new LinkedListNode(3);
        LinkedListNode fourRep = new LinkedListNode(4);
        LinkedListNode five = new LinkedListNode(5);

        LinkedListNode head = new LinkedListNode(0);

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


        LinkedListNode current = head;
        while (current.next != null) {
            System.out.print(current.next.data + "-->");
            current = current.next;
        }


        head = LinkedLists.partitionElementsAroundValue(head, 3);
        System.out.println();


        current = head;
        while (current.next != null) {
            System.out.print(current.next.data + "-->");
            current = current.next;
        }


    }

}
