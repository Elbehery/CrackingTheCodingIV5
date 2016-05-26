package CodingIV;

import java.util.*;

/**
 * Hello world!
 */
public class App {

    public static void createSuffixArray(String txt) {

        String[] suffixes = new String[txt.length()];
        int[] suffixArray = new int[txt.length()];

        for (int i = 0; i < suffixes.length; i++) {
            suffixes[i] = txt.substring(i);
        }

        Arrays.sort(suffixes);

        for (int j = 0; j < suffixes.length; j++) {
            suffixArray[j] = txt.length() - suffixes[j].length();
        }
    }


    public static void computeLCP(String str1, String str2) {

        int i = 0;

        while (i < str1.length() && i < str2.length() && str1.charAt(i) == str2.charAt(i)) {
            i++;
        }

    }


    public static boolean checkDistinctCharsInString(String s) {

        Set<Character> charMap = new HashSet<Character>();
        char[] stringToChars = s.toCharArray();

        for (int i = 0; i < stringToChars.length; i++) {
            if (charMap.contains(stringToChars[i])) {
                return false;
            } else
                charMap.add(stringToChars[i]);
        }
        return true;
    }

    public static void reverseString(String s) {

        if (s.length() == 0)
            throw new IllegalArgumentException();

        boolean evenFlag = false;
        int median;
        if (s.length() % 2 == 0)
            evenFlag = true;

        if (evenFlag)
            median = (s.length() / 2) - 1;
        else
            median = s.length() / 2;

        char[] stringToChars = s.toCharArray();

        for (int i = 0; i < median; i++) {
            char tmp = stringToChars[i];
            stringToChars[i] = stringToChars[s.length() - 1 - i];
            stringToChars[s.length() - 1 - i] = tmp;
        }

        if (evenFlag) {
            char tmp = stringToChars[median];
            stringToChars[median] = stringToChars[median + 1];
            stringToChars[median + 1] = tmp;
        }

        System.out.println(stringToChars);
    }

    // 2.1
    public static void removeDuplicateLinkedList(Node head) {

        HashSet<Integer> checkDuplicateHashSet = new HashSet<Integer>();
        Hashtable hashtable = new Hashtable();
        Node n = head;
        Node previous = null;

        while (n != null) {

            if (checkDuplicateHashSet.contains(n.data)) {

                previous.next = n.next;
            } else {
                checkDuplicateHashSet.add(n.data);
                previous = n;
            }

            n = n.next;
        }

        Node x = head;
        while (x != null) {
            System.out.println(x.data);
            x = x.next;
        }
    }

    //2.2
    public static Node findTheKthLastElement(Node head, int k, int size) {

        if (k < 0 || k > size) {
            throw new IllegalArgumentException();
        }

        Node current = head;
        int stop = size - k;
        int counter = 0;

        while (counter <= stop) {
            current = current.next;
            counter++;
        }

        return current;
    }


    //2.2
    public static int findTheKthLastElementRecursively(Node head, int k) {

        if (head == null) {
            return 0;
        }

        int i = findTheKthLastElementRecursively(head.next, k) + 1;

        if (i == k)
            System.out.println(head.data);

        return i;
    }

    //2.2
    public static Node findTheKthLastElementRecursivelyByRef(Node head, int k, Integer i) {

        if (head == null) {
            return null;
        }

        Node node = findTheKthLastElementRecursivelyByRef(head.next, k, i);
        i++;

        if (i == k)
            return head;

        return node;
    }

    //2.3
    public static boolean deleteFromSingleLinkedListWithoutHead(Node n) {

        if (n == null) {
            return false;
        }

        Node next = n.next;
        n.data = next.data;
        n.next = next.next;
        next.next = null;

        return true;

    }

    //2.5
    public static Node sumTwoNumberByLinkedList(Node head1, Node head2) {

        if (head1 == null || head2 == null) {
            throw new IllegalArgumentException();
        }

        Node current1 = head1;
        Node current2 = head2;

        Node sum = null;
        Node sumResultListHead = null;

        while (current1 != null && current2 != null) {

            // create a new in the resultList
            Node dummyNode = new Node(0);

            // handling the corner cases, and attaches the sumResultListHead to the head of the new LinkedList
            if (sum == null) {
                sum = dummyNode;
                sumResultListHead = sum;
            } else {
                sum.next = dummyNode;
                sum = sum.next;
            }

            sum.data = current1.data + current2.data;

            // update
            current1 = current1.next;
            current2 = current2.next;


        }

        while (current1 != null && current2 == null) {

            // create a new in the resultList
            Node dummyNode = new Node(0);

            // handling the corner cases, and attaches the sumResultListHead to the head of the new LinkedList
            if (sum == null) {
                sum = dummyNode;
                sumResultListHead = sum;
            } else {
                sum.next = dummyNode;
                sum = sum.next;
            }

            //update
            sum.data = current1.data;
            current1 = current1.next;
        }

        while (current2 != null && current1 == null) {

            // create a new in the resultList
            Node dummyNode = new Node(0);

            // handling the corner cases, and attaches the sumResultListHead to the head of the new LinkedList
            if (sum == null) {
                sum = dummyNode;
                sumResultListHead = sum;
            } else {
                sum.next = dummyNode;
                sum = sum.next;
            }

            //update
            sum.data = current2.data;
            current2 = current2.next;
        }


        return sumResultListHead;

    }


    public static void main(String[] args) {
        App.reverseString("ancsf");

        Node node1 = new Node(0);
        Node node2 = new Node(3);
        Node node3 = new Node(2);
        Node node4 = new Node(1);


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        Node head1 = node1;


        Node node11 = new Node(2);
        Node node22 = new Node(2);
        Node node33 = new Node(5);


        node11.next = node22;
        node22.next = node33;
        node33.next = null;


        Node head2 = node11;


        System.out.println(App.sumTwoNumberByLinkedList(head1, head2));


    }
}
