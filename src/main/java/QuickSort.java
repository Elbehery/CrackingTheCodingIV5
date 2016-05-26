import java.util.Random;

/**
 * Created by mustafa on 22.03.16.
 */
public class QuickSort {


    public static Random random = new Random();

    public static void quickSort(int[] arr, int low, int high) {

        if (low < high) {

            int q = partition(arr, low, high);
            quickSort(arr, low, q - 1);
            quickSort(arr, q + 1, high);
        }


        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public static int partition(int[] arr, int low, int high) {

        int x = arr[high];


        int i, j, tmp;
        for (j = low, i = j - 1; j < high; j++) {

            if (arr[j] < x) {
                i = i + 1;
                tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }

        tmp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = tmp;

        return i + 1;
    }


    public static void main(String[] args) {

        int[] tst = {2, 5, 6, 1, 9, 10, 12, 1};

        QuickSort.quickSort(tst, 0, tst.length - 1);

    }
}
