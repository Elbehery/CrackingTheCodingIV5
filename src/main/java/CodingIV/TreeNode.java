package CodingIV;


/**
 * Created by mustafa on 07.03.16.
 */
public class TreeNode {

    private TreeNode parent;
    private boolean leaf;
    private TreeNode left;
    private TreeNode right;
    private int height;

    public TreeNode() {

        this.parent = null;
        this.leaf = false;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = left.getHeight() + right.getHeight() + 1;
    }
}
