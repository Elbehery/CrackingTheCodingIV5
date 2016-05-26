package cracks.Tree;

/**
 * Created by mustafa on 20.03.16.
 */
public class FindSuccessor {


    public TreeNode findSuccessor(TreeNode root) {

        if (root.getRight() != null)
            return minimum(root.getRight());

        TreeNode y = root.getParent();

        while (y != null && root == y.getRight()) {

            root = y;
            y = y.getParent();
        }

        return y;

    }

    public TreeNode minimum(TreeNode root) {

        while (root.getLeft() != null) {
            root = root.getLeft();
        }

        return root;

    }
}
