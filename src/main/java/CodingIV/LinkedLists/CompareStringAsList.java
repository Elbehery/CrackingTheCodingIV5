package CodingIV.LinkedLists;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mustafa on 17.03.16.
 */
public class CompareStringAsList {

    public static int compareStringsLexically(List<Character> list1, List<Character> list2) {

        if (list1 == null || list2 == null)
            throw new NullPointerException();

        if (list1.size() > list2.size())
            return 1;

        else if (list2.size() > list1.size())
            return -1;

        int i = 0;
        // iterate as long as the character are the same
        while (i < list1.size()) {
            if (list1.get(i) > list2.get(i))
                return 1;
            else if (list2.get(i) > list1.get(i))
                return -1;
            else
                i++;
        }


        return 0;
    }

    public static void main(String[] args) {


        Character[] arr1 = {'g', 'e', 'e', 'k', 's'};
        Character[] arr2 = {'g', 'e', 'e', 'k', 's'};

        List<Character> list1 = new LinkedList<Character>(Arrays.asList(arr1));
        List<Character> list2 = new LinkedList<Character>(Arrays.asList(arr2));


        System.out.println(CompareStringAsList.compareStringsLexically(list1, list2));
    }


}
