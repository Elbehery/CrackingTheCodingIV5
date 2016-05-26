package CodingIV.LinkedLists;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mustafa on 17.03.16.
 */
public class MergeReverse {

    public static <T extends Comparable<? super T>> List<T> mergeTwoListsReverse(List<T> listA, List<T> listB) {

        if (listA == null || listB == null)
            throw new NullPointerException();


        int pointerA = 0;
        int pointerB = 0;

        LinkedList<T> mergedList = new LinkedList<T>();

        while (pointerA < listA.size() && pointerB < listB.size()) {

            T a = listA.get(pointerA);
            T b = listB.get(pointerB);


            if (a.compareTo(b) < 0) {
                mergedList.addFirst(a);
                pointerA++;

            } else if (b.compareTo(a) <= 0) {
                mergedList.addFirst(b);
                pointerB++;
            }

        }


        while (pointerB < listB.size()) {
            mergedList.addFirst(listB.get(pointerB));
            pointerB++;
        }

        while (pointerA < listA.size()) {
            mergedList.addFirst(listA.get(pointerA));
            pointerA++;
        }


        return mergedList;
    }

    public static void main(String[] args) {

        List<Integer> listA = new LinkedList<Integer>();
        listA.add(5);
        listA.add(10);
        listA.add(15);
        listA.add(40);


        List<Integer> listB = new LinkedList<Integer>();
        listB.add(2);
        listB.add(3);
        listB.add(20);

        List<Integer> list = (List<Integer>) MergeReverse.mergeTwoListsReverse(listA, listB);

        for(Integer i : list)
            System.out.print(i + " ");


    }
}
