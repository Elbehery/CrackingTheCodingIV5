package cracks.ArraysAndString;

/**
 * Created by mustafa on 19.03.16.
 */
public class ProblemFive {

    public static String compressString(String input) {

        StringBuffer distincts = new StringBuffer();
        int[] chars = new int[256];

        char last = input.charAt(0);
        distincts.append(last);
        chars[last]++;

        // process the whole input
        int i = 1;
        while (i < input.length()) {
            char current = input.charAt(i);
            if (current != last) {
                distincts.append(current);
                last = current;
            }

            // update the counts
            chars[current]++;
            i++;
        }

        // populate the output
        for (int j = 0; j < distincts.length(); j = j + 2) {
            char current = distincts.charAt(j);
            distincts.insert(j + 1, chars[current]);
        }

        return distincts.toString();

    }

    public static void main(String[] args) {
        System.out.println(ProblemFive.compressString("aabcccccaaa"));
    }
}
