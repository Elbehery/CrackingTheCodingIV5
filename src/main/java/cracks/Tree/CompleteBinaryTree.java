package cracks.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by mustafa on 22.03.16.
 */
public class CompleteBinaryTree {

    public static boolean isCompleteBinaryTreeRecursive(TreeNode node, int index, int count) {

        if (node == null)
            return true;

        if (index >= count)
            return false;


        return (isCompleteBinaryTreeRecursive(node.getLeft(), 2 * index + 1, count) && isCompleteBinaryTreeRecursive(node.getRight(), 2 * index + 2, count));
    }

    public static int countNodeInTree(TreeNode root) {

        if (root == null)
            return 0;

        return (1 + countNodeInTree(root.getLeft()) + countNodeInTree(root.getRight()));

    }

    public static boolean isCompleteBinaryTree(TreeNode root) {
        if (root == null)
            return true;


        boolean notFullNode = false;

        //HashSet<TreeNode> visited = new HashSet<TreeNode>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();
            //System.out.println(current.getData());

            // handling complete binary tree

            if (current.getLeft() != null) {

                if (notFullNode) {
                    return false;
                }

                queue.add(current.getLeft());
            } else
                notFullNode = true;


            if (current.getRight() != null) {

                if (notFullNode) {
                    return false;
                }

                queue.add(current.getRight());
            } else
                notFullNode = true;

        }

        return true;
    }


    public static void traverseTreeByLevel(TreeNode root, int level, List<LinkedList<TreeNode>> result) {

        if (root == null)
            return;


        LinkedList<TreeNode> currentLevel = null;

        if (result.size() - 1 < level) {
            result.add(new LinkedList<TreeNode>());
        }

        currentLevel = result.get(level);
        currentLevel.add(root);
        traverseTreeByLevel(root.getLeft(), level + 1, result);
        traverseTreeByLevel(root.getRight(), level + 1, result);

    }

    public static List<LinkedList<TreeNode>> createListByLevel(TreeNode root) {

        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
        traverseTreeByLevel(root, 0, result);
        return result;
    }



    public static void main(String[] args) {
        /*Queue<Integer> queue = new LinkedList<Integer>();

        Iterator<Integer> iterator = queue.iterator();

        while (iterator.hasNext())
            System.out.println(iterator.next());*/

        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);

        root.setLeft(two);
        root.setRight(three);

        two.setLeft(four);
        two.setRight(five);

        //three.setLeft(six);

        int count = CompleteBinaryTree.countNodeInTree(root);

        System.out.println(CompleteBinaryTree.isCompleteBinaryTreeRecursive(root,0,count));

        System.out.println(CompleteBinaryTree.isCompleteBinaryTree(root));


      /*  List<LinkedList<TreeNode>> result = CompleteBinaryTree.createListByLevel(root);

        for (LinkedList list : result) {

            LinkedList<TreeNode> current = list;
            for (TreeNode node : current)
                System.out.println(node.getData());
        }*/

    }
}
