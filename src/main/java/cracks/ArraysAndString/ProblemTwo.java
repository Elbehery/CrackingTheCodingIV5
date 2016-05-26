package cracks.ArraysAndString;

/**
 * Created by mustafa on 19.03.16.
 */
public class ProblemTwo {

    public static String reveseStringAuxSpace(String input) {

        StringBuffer reversed = new StringBuffer();


        for (int i = input.length() - 1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }

        return reversed.toString();
    }

    public static String reverseStringInPlace(String input) {

        char[] inputToCharArray = input.toCharArray();

        int end = input.length() - 1;
        int mid = input.length() / 2;
        int begin = 0;

        while (begin < mid) {

            char tmp = inputToCharArray[end];
            inputToCharArray[end] = inputToCharArray[begin];
            inputToCharArray[begin] = tmp;

            end--;
            begin++;
        }

        return new String(inputToCharArray);

    }


    public static void main(String[] args) {

        String test = "abcd";

        System.out.println(ProblemTwo.reverseStringInPlace(test));
    }
}
