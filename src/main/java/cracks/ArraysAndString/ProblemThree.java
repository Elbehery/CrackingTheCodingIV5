package cracks.ArraysAndString;

import java.util.Arrays;

/**
 * Created by mustafa on 19.03.16.
 */
public class ProblemThree {

    public static boolean isPermutations(String str1, String str2) {

        if (str1.length() != str2.length())
            return false;

        char[] str1ToChars = str1.toCharArray();
        char[] str2ToChars = str2.toCharArray();

        Arrays.sort(str1ToChars);
        Arrays.sort(str2ToChars);

        return new String(str1ToChars).equals(new String(str2ToChars));

    }

    public static boolean isPermutationCounts(String str1, String str2) {

        if (str1.length() != str2.length())
            return false;


        int[] chars = new int[256];

        int i = 0;
        while (i < str1.length()) {

            chars[str1.charAt(i)]++;
            i++;
        }

        int j = 0;
        while (j < str2.length()) {
            if (--chars[(int) str2.charAt(j)] < 0)
                return false;

            j++;
        }

        return true;

    }


    public static void main(String[] args) {

        System.out.println(ProblemThree.isPermutationCounts("ogc ", "dog"));
    }
}
