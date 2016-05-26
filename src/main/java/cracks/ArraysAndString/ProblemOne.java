package cracks.ArraysAndString;

/**
 * Created by mustafa on 19.03.16.
 */
public class ProblemOne {

    public static boolean isStringUnique(String input) {

        if (input.length() > 128)
            return false;

        boolean[] uniqueCharArray = new boolean[256];

        for (int i = 0; i < input.length(); i++) {

            int val = input.charAt(i);

            if (uniqueCharArray[val])
                return false;
            else
                uniqueCharArray[val] = true;
        }

        return true;
    }

    public static void main(String[] args) {

        String tst = "abcdesfh";

        System.out.println(ProblemOne.isStringUnique(tst));
    }
}
