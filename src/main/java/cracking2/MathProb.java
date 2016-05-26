package cracking2;

/**
 * Created by mustafa on 06.04.16.
 */
public class MathProb {

    public static boolean isPrime(int n) {

        if (n < 2)
            return false;

        int sqrt = (int) Math.sqrt(n);

        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }
}
