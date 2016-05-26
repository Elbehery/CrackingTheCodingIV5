package cracking2;


import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by mustafa on 06.04.16.
 */
public class LinkedListsTest {

    private LinkedList<Integer> filledLinkedList;
    private LinkedList<Integer> linkedListOneElement;
    private LinkedList<Integer> emptyLinkedList;
    private LinkedList<Integer> nullLinkedList;

    @Before
    public void initialize() {

        filledLinkedList = new LinkedList<Integer>(Arrays.asList(1, 2, 3, 4, 1, 2, 3, 5));
        linkedListOneElement = new LinkedList<Integer>(Arrays.asList(1));
        emptyLinkedList = new LinkedList<Integer>();
        nullLinkedList = null;
    }

    @Test
    public void removeDuplicatedWithoutBufferLinearithmicTest() {

        try {
            LinkedLists.removeDuplicatedWithoutBufferLinearithmic(nullLinkedList);
            Assert.fail("Null Pointer Exception is expected");
        } catch (NullPointerException ex) {

        }


        try {
            LinkedLists.removeDuplicatedWithoutBufferLinearithmic(emptyLinkedList);
            Assert.fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException ex) {

        }


        LinkedList<Integer> expected = new LinkedList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        Assert.assertEquals("remove duplicates is incorrect", expected, LinkedLists.removeDuplicatedWithoutBufferLinearithmic(filledLinkedList));


    }
}
