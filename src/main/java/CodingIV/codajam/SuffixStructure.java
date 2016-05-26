package CodingIV.codajam;

import java.util.Arrays;

/**
 * Created by mustafa on 15.03.16.
 */
public class SuffixStructure {

    public static void createSuffixArray(String text, int[] suffixArray, int[] longestCommonPrefix) {

        if (suffixArray.length < text.length() || longestCommonPrefix.length < text.length())
            throw new IllegalArgumentException();


        String[] suffixes = new String[text.length()];

        for (int i = 0; i < text.length(); i++) {
            suffixes[i] = text.substring(i);
        }

        Arrays.sort(suffixes);

        for (int i = 0; i < suffixes.length; i++) {
            suffixArray[i] = text.length() - suffixes[i].length();
        }

        for (int i = 1; i < suffixes.length; i++) {
            longestCommonPrefix[i] = computeLCPOfTwoStrings(suffixes[i - 1], suffixes[i]);
        }
    }



    private static int computeLCPOfTwoStrings(String input1, String input2) {

        if (input1 == null || input2 == null)
            throw new NullPointerException();

        if (input1.length() < 0 || input2.length() < 0)
            throw new IllegalArgumentException();


        int commonPrefix = 0;

        while (commonPrefix < input1.length() && commonPrefix < input2.length() && input1.charAt(commonPrefix) == input2.charAt(commonPrefix)) {
            commonPrefix++;
        }

        return commonPrefix;

    }

    public static void main(String[] args) {
        String test = "banana$";
        int[] suffix = new int[test.length()];
        int[] lcp = new int[test.length()];

        SuffixStructure.createSuffixArray(test,suffix,lcp);

        for(Integer i :suffix){
            System.out.print(i + " ");
        }

        System.out.println();

        for(Integer i :lcp){
            System.out.print(i + " ");
        }

    }

}
