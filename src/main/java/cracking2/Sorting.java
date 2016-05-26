package cracking2;

import java.util.*;
import java.util.Arrays;

/**
 * Created by mustafa on 06.04.16.
 */
public class Sorting {

    public static void mergeSort(int[] original) {

        int[] helper = new int[original.length];
        mergeSort(original, helper, 0, original.length - 1);
    }

    private static void mergeSort(int[] original, int[] helper, int low, int high) {

        if (low < high) {

            int median = (low + high) / 2;

            mergeSort(original, helper, low, median);
            mergeSort(original, helper, median + 1, high);
            merge(original, helper, low, median, high);
        }
    }

    private static void merge(int[] original, int[] helper, int low, int median, int high) {

        for (int i = low; i <= high; i++)
            helper[i] = original[i];

        int leftPointer = low;
        int rightPointer = median + 1;
        int current = low;

        while (leftPointer <= median && rightPointer <= high) {

            if (helper[leftPointer] < helper[rightPointer]) {
                original[current++] = helper[leftPointer++];
            } else {
                original[current++] = helper[rightPointer++];
            }
        }


        while (leftPointer <= median) {
            original[current++] = helper[leftPointer++];
        }
    }

    public static void quickSort(List<Comparable> source) {

        if (source.size() < 1)
            return;

        List<Comparable> smaller = new ArrayList<>();
        List<Comparable> same = new ArrayList<>();
        List<Comparable> larger = new ArrayList<>();

        int median = source.size() / 2;

        Collections.shuffle(source);
        Comparable pivot = source.get(median);

        for (Comparable comparable : source) {
            if (comparable.compareTo(pivot) < 0)
                smaller.add(comparable);
            else if (comparable.compareTo(pivot) > 0)
                larger.add(comparable);
            else same.add(comparable);
        }

        quickSort(smaller);
        quickSort(larger);

        source.clear();
        source.addAll(smaller);
        source.addAll(same);
        source.addAll(larger);
    }

    public static int binarySearchIteratively(int[] source, int target) {

        int low = 0;
        int high = source.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (target < source[mid])
                high = mid - 1;
            else if (target > source[mid])
                low = mid + 1;
            else
                return mid;
        }

        return -1;
    }

    public static int binarySearchRecursively(int[] source, int target, int low, int high) {

        if (low > high)
            return -1;

        int mid = (low + high) / 2;

        if (target < source[mid])
            return binarySearchRecursively(source, target, low, mid - 1);
        else if (target > source[mid])
            return binarySearchRecursively(source, target, mid + 1, high);

        return mid;
    }

    public static void sortArrayAnagram(String[] anagrams) {

        Arrays.sort(anagrams, new AnagramComparator());

    }

    private static class AnagramComparator implements Comparator<String> {

        private String sortAnagrams(String s) {

            char[] anagramChars = s.toCharArray();
            java.util.Arrays.sort(anagramChars);

            return new String(anagramChars);

        }

        @Override
        public int compare(String o1, String o2) {
            return sortAnagrams(o1).compareTo(sortAnagrams(o2));
        }
    }

    public static void sortTwoArraysInTheLargerSortedOrder(int[] a, int[] b, int lastA, int lastB) {

        int aIndex = lastA - 1;
        int bIndex = lastB - 1;
        int mergeIndex = lastA + lastB - 1;

        while (bIndex > 0) {

            if (aIndex >= 0 && a[aIndex] > b[bIndex])
                a[mergeIndex--] = a[aIndex--];
            else
                a[mergeIndex--] = b[bIndex--];
        }
    }

    public static void main(String[] args) {
        int[] tst = {0, 1, 3, 4, 5, 7, 9};

        System.out.println(Sorting.binarySearchRecursively(tst, 9, 0, tst.length - 1));

   /*     List<Comparable> source = new ArrayList<Comparable>(java.util.Arrays.asList(tst));

        Sorting.quickSort(source);

        for (int i = 0; i < source.size(); i++)
            System.out.print(source.get(i) + " ");*/
    }
}
