package cracks.Tree;


/**
 * Created by mustafa on 20.03.16.
 */
public class BalancedBinaryTree {

    public int getHeight(TreeNode node) {

        if (node == null)
            return 0;

        int leftHeight = getHeight(node.getLeft());
        if (leftHeight == -1)
            return -1;

        int rightHeight = getHeight(node.getRight());
        if (rightHeight == -1)
            return -1;

        int currentHeight = Math.abs(leftHeight - rightHeight);
        if (currentHeight > 1) {
            return -1;
        } else
            return Math.max(leftHeight, rightHeight) + 1;
    }


    public boolean checkBalanded(TreeNode node) {
        if (node == null)
            return false;

        int height = getHeight(node);
        if (height == -1)
            return false;

        return true;
    }
}
