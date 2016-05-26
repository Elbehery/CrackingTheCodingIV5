package CodingIV.codajam;


public class MyArrayList<AnyType> implements Iterable<AnyType> {
    private int theSize;
    private AnyType[] theItems;

    public java.util.Iterator<AnyType> iterator() {
        return new ArrayListIterator();
    }

    public int size() {
        return theSize;
    }

    private class ArrayListIterator implements java.util.Iterator<AnyType> {
        private int current = 0;


        public boolean hasNext() {
            return current < theSize;
        }

        public AnyType next() {
            return theItems[current++];
        }

        public void remove() {

        }
    }

}


