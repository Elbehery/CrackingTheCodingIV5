package cracking2;

import java.util.EmptyStackException;

/**
 * Created by mustafa on 06.04.16.
 */
public class ThreeStacks {

    private final static int STACK_SIZE = 100;
    int[] buffer = new int[STACK_SIZE * 3];
    int[] stackPointer = {-1, -1, -1};

    public void push(int item, int stackNumber) {

        if (isStackFull(stackNumber)) {
            throw new IndexOutOfBoundsException("Stack is Full");
        }

        stackPointer[stackNumber]++;
        buffer[getStackIndex(stackNumber)] = item;
    }


    public int pop(int stackNumber) {

        if (isStackEmpty(stackNumber)) {
            throw new EmptyStackException();
        }

        int item = buffer[getStackIndex(stackNumber)];
        buffer[getStackIndex(stackNumber)] = 0;
        stackPointer[stackNumber]--;

        return item;
    }

    public int peek(int stackNumber) {

        if (isStackEmpty(stackNumber)) {
            throw new EmptyStackException();
        }

        return buffer[getStackIndex(stackNumber)];

    }


    public boolean isStackEmpty(int stackNumber) {

        return stackPointer[stackNumber] < 0;
    }


    public boolean isStackFull(int stackNumber) {

        return stackPointer[stackNumber] + 1 >= STACK_SIZE;
    }

    private int getStackIndex(int stackNumber) {

        return stackNumber * STACK_SIZE + stackPointer[stackNumber];
    }
}
