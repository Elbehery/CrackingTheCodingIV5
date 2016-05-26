package CodingIV.Array;

/**
 * Created by mustafa on 18.03.16.
 */
public class IncreasingSubarrays {

    public static <T extends Comparable<? super T>> int countStrictlyIncreasingSubArrays(T[] input) {

        int counter = 0;

        for (int i = 0; i < input.length; i++) {

            T lastElement = input[i];

            for (int j = i + 1; j < input.length; j++) {
                if (!(input[j].compareTo(lastElement) > 0)) {
                    break;
                }

                counter++;
                lastElement = input[j];
            }
        }

        return counter;
    }

    public static void main(String[] args) {


        Integer[] tst = {1, 2, 3, 4};

        System.out.println(IncreasingSubarrays.countStrictlyIncreasingSubArrays(tst));
    }
}
