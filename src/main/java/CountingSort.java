/**
 * Created by mustafa on 22.03.16.
 */
public class CountingSort {

    public static void countSort(int[] arr, int max) {

        int n = arr.length;
        int[] counts = new int[max + 1];
        int[] sorted = new int[n];

        for (int i = 0; i < n; i++) {
            counts[arr[i]]++;
        }


        for (int j = 1; j < counts.length; j++) {
            counts[j] = counts[j] + counts[j - 1];
        }

        for (int k = sorted.length - 1; k >= 0; k--) {

            sorted[counts[arr[k]] -1] = arr[k];
            counts[arr[k]]--;
        }


        for (int i = 0; i < arr.length; i++)
            System.out.print(sorted[i] + " ");


    }


    public static void main(String[] args) {


        int[] tst = {2, 5, 3, 0, 2, 3, 0, 3};
        CountingSort.countSort(tst, 5);
    }

}
