package cracking2;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mustafa on 05.04.16.
 */
public class Arrays {

    public static boolean stringAllUniqueChars(String s) {

        if (s == null)
            throw new NullPointerException();

        if (s == "")
            throw new IllegalArgumentException();

        Set<Character> charactersMap = new HashSet<Character>();

        char[] stringChars = s.toCharArray();

        for (Character character : stringChars) {

            if (charactersMap.contains(character))
                return false;

            else
                charactersMap.add(character);
        }

        return true;
    }

    public static String reverseString(String input) {

        if (input == null)
            throw new NullPointerException();

        if (input == "")
            return input;


        StringBuffer buffer = new StringBuffer();

        for (int i = input.length(); i >= 1; i--) {
            buffer.append(input.substring(i - 1, i));
        }

        return buffer.toString();
    }

    public static String reverseStringInPlace(String input) {

        if (input == null)
            throw new NullPointerException();

        if (input == "")
            return input;

        char[] chars = input.toCharArray();
        int left, right = input.length() - 1;

        for (left = 0; left < right; left++, right--) {
            char tmp = chars[right];
            chars[right] = chars[left];
            chars[left] = tmp;
        }

        return new String(chars);

    }

    public static boolean isStringPermutationOfAnother(String inputOne, String inputTwo) {

        if (inputOne == null || inputTwo == null)
            throw new NullPointerException();

        if (inputOne.length() != inputTwo.length())
            return false;

        return sortStringAlphabets(inputOne).equals(sortStringAlphabets(inputTwo));

    }

    private static String sortStringAlphabets(String input) {
        if (input == null)
            throw new NullPointerException();

        char[] chars = input.toCharArray();

        java.util.Arrays.sort(chars);

        return new String(chars);
    }

    public static boolean isStringPermutationOfAnotherOptimized(String inputOne, String inputTwo) {

        if (inputOne == null || inputTwo == null)
            throw new NullPointerException();

        if (inputOne.length() != inputTwo.length())
            return false;


        int[] alphabets = new int[256];

        char[] charsInputOne = inputOne.toCharArray();
        char[] charsInputTwo = inputTwo.toCharArray();

        for (Character character : charsInputOne)
            alphabets[character]++;

        for (Character character : charsInputTwo) {
            if (--alphabets[character] < 0)
                return false;
        }


        return true;
    }

    public static String compressString(String input) {

        char[] inputChars = input.toCharArray();
        Character current = inputChars[0];
        int currentCount = 1;

        StringBuffer compressedString = new StringBuffer();

        for (int i = 1; i < inputChars.length; i++) {

            if (!current.equals(inputChars[i])) {
                compressedString.append(current);
                compressedString.append(currentCount);

                current = inputChars[i];
                currentCount = 1;

            } else {
                currentCount++;
            }
        }

        compressedString.append(current);
        compressedString.append(currentCount);

        if (compressedString.length() >= input.length())
            return input;

        return compressedString.toString();

    }


    public static void main(String[] args) {


        String tst = "aabcccccaaa";
        String tst2 = "abcdefffffffg";

        System.out.println(Arrays.compressString(tst2));
    }
}
