package cracks.Stack;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by mustafa on 20.03.16.
 */
public class SetOfStacks {

    private List<Stack> stackList;
    private int threshold;

    public SetOfStacks(int stackSize) {
        threshold = stackSize;
        cracks.Stack.Stack stack = new Stack(threshold);
        stackList = new ArrayList<Stack>();
        stackList.add(stack);
    }

    public void push(Integer item) {

        if (stackList.isEmpty())
            stackList.add(new Stack(threshold));

        if (stackList.get(stackList.size() - 1).isFull()) {
            stackList.add(new Stack(threshold));
            System.out.println(stackList.size());

        }

        stackList.get(stackList.size() - 1).push(item);
    }

    public Integer pop() {
        if (stackList.get(stackList.size() - 1).isEmpty()) {
            stackList.remove(stackList.size() - 1);
            System.out.println(stackList.size());
        }

        if (stackList.isEmpty()) {
            return -1;
        }

        return stackList.get(stackList.size() - 1).pop();
    }

    public static void main(String[] args) {


        SetOfStacks setOfStacks = new SetOfStacks(3);
        setOfStacks.push(1);
        setOfStacks.push(1);
        setOfStacks.push(1);
        setOfStacks.pop();
        setOfStacks.pop();
        setOfStacks.pop();
        setOfStacks.pop();


        setOfStacks.push(1);
        setOfStacks.push(1);
        setOfStacks.push(1);

        setOfStacks.push(1);
        setOfStacks.push(1);
        setOfStacks.push(1);
        setOfStacks.push(1);
        setOfStacks.push(1);
        setOfStacks.push(1);
        setOfStacks.pop();
        setOfStacks.pop();
        setOfStacks.pop();
        setOfStacks.pop();


    }
}
