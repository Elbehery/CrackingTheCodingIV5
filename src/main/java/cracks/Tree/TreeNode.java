package cracks.Tree;

import java.util.List;

/**
 * Created by mustafa on 20.03.16.
 */
public class TreeNode {

    private TreeNode parent;
    private TreeNode right;
    private TreeNode left;
    private int data;

    private List<TreeNode> adjacencyList;

    TreeNode() {

    }

    public TreeNode(int data) {

        this.data = data;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public List<TreeNode> getAdjacencyList() {
        return adjacencyList;
    }

    public void setAdjacencyList(List<TreeNode> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }
}
