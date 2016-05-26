package junit;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItem;

/**
 * Created by mustafa on 04.04.16.
 */
public class TestHamcrest {

    private List<String> values;

    @Before
    public void initializeTest() {

        values = new ArrayList<String>();
        values.add("x");
        values.add("y");
        values.add("z");
    }


    @Test
    public void testWithoutHamcrest() {

        Assert.assertTrue(values.contains("x") || values.contains("y") || values.contains("z"));

    }

    @Test
    public void testWithHamcrest() {

        assertThat(values, hasItem(anyOf(equalTo("x"))));
    }

}
