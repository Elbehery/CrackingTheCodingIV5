package CodingIV.codajam;

/**
 * Created by mustafa on 16.03.16.
 */
public class Geek4Geek {


    public static int sumOfBitDifferencesBruteForce(int[] A) {

        if (A == null)
            throw new NullPointerException();

        if (A.length <= 0)
            throw new IllegalArgumentException();

        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = A.length - 1; j > i; j--) {

                StringBuilder firstNumber = new StringBuilder(Integer.toBinaryString(A[i]));
                StringBuilder secondNumber = new StringBuilder(Integer.toBinaryString(A[j]));

                if (firstNumber.length() < secondNumber.length()) {

                    int pads = secondNumber.length() - firstNumber.length();
                    firstNumber.replace(0, firstNumber.length(), paddingLeftOfIntegerBinaryRepresentation(firstNumber.toString(), pads));
                } else if(secondNumber.length() < firstNumber.length()){

                    int pads = firstNumber.length() - secondNumber.length();
                    secondNumber.replace(0, secondNumber.length(), paddingLeftOfIntegerBinaryRepresentation(secondNumber.toString(), pads));

                }


                sum += countTheNumberDifferentBits(firstNumber.toString(), secondNumber.toString()) * 2;

            }
        }

        return sum;
    }

    private static int countTheNumberDifferentBits(String str1, String str2) {

        if (str1 == null || str2 == null)
            throw new NullPointerException();

        if (str1.length() != str2.length())
            throw new IllegalArgumentException();

        int counter = 0;

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i))
                counter++;
        }

        return counter;
    }

    private static String paddingLeftOfIntegerBinaryRepresentation(String input, int pads) {

        StringBuilder padder = new StringBuilder(input);
        int i = pads;
        while (i > 0) {
            padder.insert(0, "0");
            i--;
        }

        return padder.toString();
    }

    public static void main(String[] args) {

        int[] tst = {1, 2};

        System.out.println(sumOfBitDifferencesBruteForce(tst));
/*        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(3));
        System.out.println(Integer.toBinaryString(8));*/
    }
}
