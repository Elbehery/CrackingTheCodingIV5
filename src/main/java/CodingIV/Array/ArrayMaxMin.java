package CodingIV.Array;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mustafa on 18.03.16.
 */
public class ArrayMaxMin {

    public static <T> T[] sortedArrayIntoMaxMin(T[] sortedInput, Class<T> c) {

        T[] maxMinFormat = (T[]) Array.newInstance(c, sortedInput.length);

        int median = sortedInput.length / 2;
        int minPointer = 0;
        int maxPointer = sortedInput.length - 1;
        int i = 1;

        while (i < sortedInput.length && minPointer < median) {

            maxMinFormat[i - 1] = sortedInput[maxPointer];
            maxMinFormat[i] = sortedInput[minPointer];

            i += 2;
            minPointer++;
            maxPointer--;

        }

        if (sortedInput.length % 2 != 0)
            maxMinFormat[sortedInput.length - 1] = sortedInput[minPointer];


        return maxMinFormat;
    }

    public static void main(String[] args) {

        Integer[] tst = {1, 2, 3, 4, 5, 6, 7};
        Integer[] result = ArrayMaxMin.sortedArrayIntoMaxMin(tst, Integer.class);

        for (Integer i : result)
            System.out.println(i);

    }


}
