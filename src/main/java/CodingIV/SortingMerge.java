package CodingIV;

/**
 * Created by mustafa on 06.04.16.
 */
public class SortingMerge {

    public static void mergeSort(int[] source) {

        int[] aux = new int[source.length];
        mergeSort(source, aux, 0, source.length - 1);
    }

    private static void mergeSort(int[] source, int[] aux, int low, int high) {

        if (low < high) {

            int median = (low + high) / 2;
            mergeSort(source, aux, low, median);
            mergeSort(source, aux, median + 1, high);
            merge(source, aux, low, median, high);
        }
    }


    private static void merge(int[] source, int[] aux, int low, int median, int high) {

        for (int i = low; i <= high; i++)
            aux[i] = source[i];


        int leftPointer = low;
        int rightPointer = median + 1;
        int current = low;


        while (leftPointer <= median && rightPointer <= high) {
            if (aux[leftPointer] < aux[rightPointer]) {
                source[current++] = aux[leftPointer++];
            } else
                source[current++] = aux[rightPointer++];
        }

        while (leftPointer <= median) {
            source[current++] = aux[leftPointer++];
        }
    }

    public static void main(String[] args) {
        int[] tst = {5, 1, 7, 9, 3, 0, 4};

        SortingMerge.mergeSort(tst);


        for (int i = 0; i < tst.length; i++)
            System.out.print(tst[i] + " ");
    }
}
