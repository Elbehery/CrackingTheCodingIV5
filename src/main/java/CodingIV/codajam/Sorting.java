package CodingIV.codajam;

import java.util.*;

/**
 * Created by mustafa on 15.03.16.
 */
public class Sorting {

    public static void insertionSort(Comparable[] A, int length) {

        for (int i = 1; i < length; i++) {
            for (int j = i - 1; j >= 0; j--) {

                if (A[j + 1].compareTo(A[j]) < 0) {
                    Comparable tmp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = tmp;
                }

            }
        }


    }

    public static void heapSort(Comparable[] A, int length) {


        int heapSize = A.length;

        // buildMaxHeap
        for (int i = length / 2 - 1; i >= 0; i--) {
            maxHeapify(A, i, A.length);
        }

        for (int i = length - 1; i >= 0; i--) {
            Comparable tmp = A[heapSize - 1];
            A[heapSize - 1] = A[0];
            A[0] = tmp;
            heapSize--;
            maxHeapify(A, 0, heapSize);
        }


        for (int i = 0; i < length; i++) {
            System.out.print(A[i] + " ");
        }

    }

    private static void maxHeapify(Comparable[] A, int i, int heapSize) {

        if (A == null)
            throw new NullPointerException();

        if (A.length <= 0)
            throw new IllegalArgumentException();


        int child = getLeftChild(i);
        int largestIndex = -1;

        while (i < heapSize / 2) {

            Comparable largest = A[i];
            if (largest.compareTo(A[child]) < 0) {
                largest = A[child];
                largestIndex = child;
            }

            if (child != heapSize - 1 && largest.compareTo(A[child + 1]) < 0) {

                child++;
                largest = A[child];
                largestIndex = child;

            }

            if (largestIndex != -1 && largestIndex != i) {
                Comparable tmp = A[i];
                A[i] = largest;
                A[largestIndex] = tmp;
            }

            // sanity check
            if (i == 0 && largestIndex == -1)
                break;

            i = child;

        }


    }


    private static int getParent(int i) {
        return i / 2;
    }

    private static int getLeftChild(int i) {

        int index = (i * 2) + 1;
        return index;
    }

    public static void QuickSort(List<Comparable> A) {

        if (A.size() < 1)
            return;

        List<Comparable> smaller = new ArrayList<Comparable>();
        List<Comparable> same = new ArrayList<Comparable>();
        List<Comparable> larger = new ArrayList<Comparable>();

        // picking the pivot at random
        Random rand = new Random();
        Comparable pivot = A.get(rand.nextInt(A.size()));

        for (Comparable item : A) {

            if (item.compareTo(pivot) < 0)
                smaller.add(item);
            else if (item.compareTo(pivot) > 0)
                larger.add(item);
            else
                same.add(item);
        }

        QuickSort(smaller);
        QuickSort(larger);

        A.clear();
        A.addAll(smaller);
        A.addAll(same);
        A.addAll(larger);

        for (Comparable item : A) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static <T> List<T> heapSort(List<T> unsortedList) {

        Queue<T> priorityQueue = new PriorityQueue<T>(unsortedList);
        List<T> result = new ArrayList<T>();

        while (!priorityQueue.isEmpty()) {
            result.add(priorityQueue.remove());
        }


        return result;
    }

    public static Map<String, List<String>> createMapOfAnagrams(List<String> words) {

        Map<String, List<String>> anagramsMap = new HashMap<String, List<String>>();

        for (String word : words) {
            String anagram = alphabtize(word);
            if (anagramsMap.containsKey(anagram)) {
                anagramsMap.get(anagram).add(word);
            } else {
                List<String> dummyList = new LinkedList<String>();
                dummyList.add(word);
                anagramsMap.put(anagram, dummyList);
            }
        }

        return anagramsMap;
    }

    private static String alphabtize(String word) {

        char[] chars = word.toCharArray();
        Arrays.sort(chars);

        return new String(chars);

    }


    public static void main(String[] args) {
        Integer[] tst = {10, 2, 5, 3, 6, 8};
        List<Comparable> input = new LinkedList<Comparable>(Arrays.asList(tst));
        //System.out.println(new Random().nextInt(input.size()));
        //Collections.shuffle(input);
        //Sorting.QuickSort(input);

        /*List<Integer> sorted = Sorting.heapSort(Arrays.asList(tst));

        for (Integer item : sorted)
            System.out.print(item + " ");*/


        HashSet<Integer> hashSetTest = new HashSet<Integer>();
        hashSetTest.add(1);
        hashSetTest.add(2);
        hashSetTest.add(3);
        hashSetTest.add(4);


        Iterator<Integer> hashSetIterator = hashSetTest.iterator();

        while (hashSetIterator.hasNext())
            System.out.println(hashSetIterator.next());

    }
}
