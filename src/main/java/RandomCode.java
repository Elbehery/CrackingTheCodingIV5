import java.util.*;

/**
 * Created by mustafa on 04.04.16.
 */
public class RandomCode {

    public static <T extends Comparable<? super T>> List<T> mergeCollections(
            Collection<? extends T> collectionOne, Collection<? extends T> collectionTwo) {

        List<T> mergedList = new LinkedList<T>();

        Iterator<? extends T> collectionOneIterator = collectionOne.iterator();
        Iterator<? extends T> collectionTwoIterator = collectionTwo.iterator();

        T elementOne = getNextElementFromIterator(collectionOneIterator);
        T elementTwo = getNextElementFromIterator(collectionTwoIterator);

        while (elementOne != null || elementTwo != null) {

            boolean flag = (elementTwo == null) || (elementOne != null && elementOne.compareTo(elementTwo) < 0);

            if (flag) {
                mergedList.add(elementOne);
                elementOne = getNextElementFromIterator(collectionOneIterator);
            } else {
                mergedList.add(elementTwo);
                elementTwo = getNextElementFromIterator(collectionTwoIterator);
            }
        }

        return mergedList;
    }

    private static <E> E getNextElementFromIterator(Iterator<E> iterator) {

        if (iterator.hasNext())
            return iterator.next();

        return null;
    }


    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(5, 7, 2, 0, 22, 66);
        List<Integer> list2 = Arrays.asList(88, 33, 77, 99, 11111, 1, 4, 8);

        List<Integer> merged = mergeCollections(list1, list2);


        Iterator<Integer> mergedIterator = merged.iterator();

        while (mergedIterator.hasNext())
            System.out.println(mergedIterator.next());

    }


}
