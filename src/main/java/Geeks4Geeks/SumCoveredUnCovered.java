package Geeks4Geeks;

import cracks.Tree.TreeNode;

/**
 * Created by mustafa on 26.03.16.
 */
public class SumCoveredUnCovered {

    private static int sumUnCovered(TreeNode node) {

        if (node == null)
            return 0;

        int sum = node.getData();
        boolean flag = true;

        if (node.getLeft() != null) {
            flag = false;
            sum += sumUnCovered(node.getLeft());
        }

        if (node.getRight() != null && flag)
            sum += sumUnCovered(node.getRight());


        return sum;

    }

    public static int sumUnCoveredTrigger(TreeNode root) {

        int sum = 0;

        if (root.getLeft() != null) {
            sum += sumUnCovered(root.getLeft());
        }

        if (root.getRight() != null) {

            sum += sumUnCovered(root.getRight());
        }

        sum += root.getData();

        return sum;
    }

    public static int inorderTreeSum(TreeNode root) {

        if (root == null)
            return 0;

        int sum = 0;

        if (root.getLeft() != null)
            sum += inorderTreeSum(root.getLeft());

        if (root.getRight() != null)
            sum += inorderTreeSum(root.getRight());


        sum += root.getData();

        return sum;
    }

    public static boolean isCoveredAndUnCoveredSumEquals(int coveredSum, int uncoveredSum) {

        if (coveredSum == uncoveredSum)
            return true;


        return false;
    }


    public static void main(String[] args) {

        // root
        TreeNode root = new TreeNode(8);

        // level one
        TreeNode three = new TreeNode(3);
        TreeNode ten = new TreeNode(10);

        // level two
        TreeNode six = new TreeNode(6);
        TreeNode one = new TreeNode(1);
        TreeNode fourteen = new TreeNode(14);


        TreeNode thirteen = new TreeNode(13);
        TreeNode seven = new TreeNode(7);
        TreeNode four = new TreeNode(4);


        root.setLeft(three);
        root.setRight(ten);

        three.setLeft(one);
       // three.setRight(six);
        ten.setRight(fourteen);

        six.setRight(seven);
        six.setLeft(four);
        fourteen.setLeft(thirteen);

        int uncoveredSum = SumCoveredUnCovered.sumUnCoveredTrigger(root);
        System.out.println(uncoveredSum);

        int allSum = SumCoveredUnCovered.inorderTreeSum(root);
        System.out.println(allSum);

        System.out.println(SumCoveredUnCovered.isCoveredAndUnCoveredSumEquals(allSum, uncoveredSum));
    }
}
