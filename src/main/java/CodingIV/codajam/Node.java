package CodingIV.codajam;

/**
 * Created by mustafa on 14.03.16.
 */
public class Node<Pair> {

    private Pair pair;
    private Node left;
    private Node right;

    public Node(Pair pair) {
        this.pair = pair;
        left = null;
        right = null;
    }

}
