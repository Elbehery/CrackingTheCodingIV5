package CodingIV.LinkedLists;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mustafa on 17.03.16.
 */
public class RearrangeList {

    public static <T extends Comparable<? super T>> List<T> rearrangeLists(List<T> input) {

        int headPointer = 0;
        int tailPointer = input.size() - 1;

        int midPoint = input.size() / 2;

        while (headPointer <= midPoint) {

            input.add(++headPointer, input.get(tailPointer));
            input.remove(tailPointer + 1);
            headPointer++;

        }

        return input;
    }


    public static void main(String[] args) {


        Integer[] arrInput = {1, 2, 3, 4, 5};
        List<Integer> inputTest = new LinkedList<Integer>(Arrays.asList(arrInput));
        List<Integer> output = RearrangeList.rearrangeLists(inputTest);

        Iterator<Integer> outputIterator = output.iterator();
        while (outputIterator.hasNext())
            System.out.print(outputIterator.next() + "    ");
    }
}
