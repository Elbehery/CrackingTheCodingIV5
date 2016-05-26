package cracking2;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by mustafa on 05.04.16.
 */
public class ArraysTest {

    private String unique;
    private String notUnique;
    private String nullString;
    private String badString;

    private String reverseTest;

    @Before
    public void initialize() {

        unique = "abcdef";
        notUnique = "abcdeff";
        nullString = null;
        badString = "";

        reverseTest = "abcd";

    }

    @Test(expected = IllegalArgumentException.class)
    public void testStringAllUniqueChars() {

        boolean uniqueResult = Arrays.stringAllUniqueChars(unique);
        Assert.assertTrue(uniqueResult);

        boolean notUniqueResult = Arrays.stringAllUniqueChars(notUnique);
        Assert.assertFalse(notUniqueResult);

        Arrays.stringAllUniqueChars(badString);

    }

    @Test(expected = NullPointerException.class)
    public void testStringAllUniqueCharsNotDefined() {

        Arrays.stringAllUniqueChars(nullString);

    }

    @Test(expected = NullPointerException.class)
    public void reverseStringTest() {

        Arrays.reverseString(nullString);
        Arrays.reverseStringInPlace(nullString);

        String result = Arrays.reverseString(reverseTest);
        Assert.assertEquals("Reversed String is incorrect", "dcba", result);

        result = Arrays.reverseStringInPlace(reverseTest);
        Assert.assertEquals("Reversed String is incorrect", "dcba", result);

    }
}
