package CodingIV.LinkedLists;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mustafa on 18.03.16.
 */
public class AlternatingLinkedList {

    public static <T extends Comparable<? super T>> List<T> sortAlternatingLists(List<T> alternatingList) {

        // create a list to hold the descending ordered Lists
        LinkedList<T> descendingList = new LinkedList<T>();

        // merge
        int pointer = 1;
        while (pointer < alternatingList.size()) {

            descendingList.addFirst(alternatingList.remove(pointer));
            pointer++;
        }

        LinkedList<T> mergedList = new LinkedList<T>();
        return mergeTwoListsRecursively(alternatingList, descendingList, mergedList);
    }


    private static <T extends Comparable<? super T>> List<T> mergeTwoLists(List<T> listA, List<T> listB) {

        if (listA == null || listB == null)
            throw new NullPointerException();


        int pointerA = 0;
        int pointerB = 0;

        LinkedList<T> mergedList = new LinkedList<T>();

        while (pointerA < listA.size() && pointerB < listB.size()) {

            T a = listA.get(pointerA);
            T b = listB.get(pointerB);


            if (a.compareTo(b) < 0) {
                mergedList.add(a);
                pointerA++;

            } else if (b.compareTo(a) <= 0) {
                mergedList.add(b);
                pointerB++;
            }

        }


        while (pointerB < listB.size()) {
            mergedList.add(listB.get(pointerB));
            pointerB++;
        }

        while (pointerA < listA.size()) {
            mergedList.add(listA.get(pointerA));
            pointerA++;
        }


        return mergedList;
    }

    private static <T extends Comparable<? super T>> List<T> mergeTwoListsRecursively(List<T> listA, List<T> listB, List<T> mergedList) {

        // base cases
        if (listA.size() == 0) {
            mergedList.addAll(listB);
            listB.clear();
            return mergedList;

        } else if (listB.size() == 0) {
            mergedList.addAll(listA);
            listA.clear();
            return mergedList;
        }


        // recursive call after updating lists.
        if (listA.get(0).compareTo(listB.get(0)) < 0)
            mergedList.add(listA.remove(0));
        else
            mergedList.add(listB.remove(0));

        return mergeTwoListsRecursively(listA, listB, mergedList);
    }


    public static void main(String[] args) {

        Integer[] tst = {10, 40, 53, 30, 67, 12, 89};

        List<Integer> tstList = new LinkedList<Integer>(Arrays.asList(tst));
        List<Integer> result = AlternatingLinkedList.sortAlternatingLists(tstList);

        for (Integer item : result)
            System.out.print(item + " ");

    }


}
