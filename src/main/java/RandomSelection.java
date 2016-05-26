/**
 * Created by mustafa on 22.03.16.
 */
public class RandomSelection {


    public static int randomSelect(int[] arr, int low, int high, int ith) {

        if (low == high)
            return arr[low];


        int q = partition(arr, low, high);
        int k = q - low + 1;

        if (ith == k)
            return arr[q];

        else if (k > ith)
            return randomSelect(arr, low, q - 1, ith);
        else
            return randomSelect(arr, q + 1, high, ith - k);


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
        System.out.println(RandomSelection.randomSelect(tst, 0, tst.length - 1, 3));
        ;
    }
}
