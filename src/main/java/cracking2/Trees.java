package cracking2;

import java.util.*;

/**
 * Created by mustafa on 06.04.16.
 */
public class Trees {

    public static boolean isBalanced(TreeNodee root) {

        if (getTreeHeight(root) == -1)
            return false;

        return true;
    }

    private static int getTreeHeight(TreeNodee root) {

        if (root == null)
            return 0;

        int leftHeight = getTreeHeight(root.left);
        if (leftHeight == -1)
            return -1;

        int rightHeight = getTreeHeight(root.right);
        if (rightHeight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;

    }

    public static boolean isRoute(Vertex src, Vertex dst) {

        Set<Vertex> visited = new HashSet<>();
        java.util.Queue<Vertex> queue = new LinkedList<>();

        visited.add(src);
        queue.add(src);

        boolean isPath = false;

        while (!queue.isEmpty()) {

            Vertex current = queue.remove();
            for (Vertex vertex : current.adjList) {

                if (!visited.contains(vertex)) {

                    // if path exist
                    if (vertex.equals(dst)) {
                        isPath = true;
                        break;
                    }

                    visited.add(vertex);
                    queue.add(vertex);
                }
            }

        }

        return isPath;
    }

    public static TreeNodee createBinarySearchTreeFromSortedArray(int[] arr, int low, int high) {


        if (low >= high)
            return null;

        int median = (low + high) / 2;
        TreeNodee root = new TreeNodee();

        root.data = arr[median];
        root.left = createBinarySearchTreeFromSortedArray(arr, low, median - 1);
        root.right = createBinarySearchTreeFromSortedArray(arr, median + 1, high);

        return root;

    }

    public static List<List<Vertex>> createLinkedListOfEachLever(Vertex root, List<List<Vertex>> result, int level) {

        if (result.size() == level) {
            result.add(new ArrayList<Vertex>());
        }

        List<Vertex> thisLevel = result.get(level);
        thisLevel.add(root);

        for (Vertex vertex : root.adjList)
            createLinkedListOfEachLever(vertex, result, level + 1);

        return result;

    }

    public static void createLinkedListOfEachLeverTreeNodeDFS(TreeNodee root, List<List<TreeNodee>> result, int level) {

        if (root == null)
            return;

        if (result.size() == level) {
            result.add(new ArrayList<TreeNodee>());
        }

        List<TreeNodee> currentLevel = result.get(level);
        currentLevel.add(root);

        createLinkedListOfEachLeverTreeNodeDFS(root.left, result, level + 1);
        createLinkedListOfEachLeverTreeNodeDFS(root.right, result, level + 1);

    }

    public static List<List<TreeNodee>> createLinkedListOfEachLeverTreeNodeBFS(TreeNodee root, List<List<TreeNodee>> result) {

        List<TreeNodee> currentLevel = new ArrayList<>();
        result.add(currentLevel);

        if (root != null)
            currentLevel.add(root);

        while (currentLevel.size() > 0) {

            List<TreeNodee> parent = currentLevel;
            currentLevel = new ArrayList<>();

            for (TreeNodee node : parent) {

                if (node.left != null)
                    currentLevel.add(node.left);

                if (node.right != null)
                    currentLevel.add(node.right);
            }

            result.add(currentLevel);
        }

        return result;
    }

    public static boolean isBinarySearchTree(TreeNodee root) {

        if (root == null)
            return true;


        List<Integer> traversedTree = new ArrayList<>();
        inOrderTraversalIteratively(root, traversedTree);

        // check if the List Sorted
        for (int i = 1; i < traversedTree.size(); i++) {
            if (traversedTree.get(i - 1) > traversedTree.get(i))
                return false;
        }

        return true;

    }

    private static void inOrderTraversalRecursively(TreeNodee root, List<Integer> traversedTree) {

        if (root.left != null)
            inOrderTraversalRecursively(root.left, traversedTree);

        traversedTree.add(root.data);

        if (root.right != null)
            inOrderTraversalRecursively(root.right, traversedTree);

    }

    private static void inOrderTraversalIteratively(TreeNodee root, List<Integer> traversedTree) {

        if (root == null)
            return;

        LinkedList<TreeNodee> stackList = new LinkedList<>();
        TreeNodee current = root;

        while (current != null) {
            stackList.addFirst(current);
            current = current.left;
        }

        while (stackList.size() > 0) {

            current = stackList.removeFirst();
            traversedTree.add(current.data);

            if (current.right != null) {
                current = current.right;

                while (current != null) {
                    stackList.addFirst(current);
                    current = current.left;

                }
            }
        }
    }

    public static boolean isBinarySearchTreeWithoutList(TreeNodee root, int min, int max) {

        if (root == null)
            return true;

        if ((root.data <= min) || root.data > max)
            return false;

        if (!isBinarySearchTreeWithoutList(root.left, min, root.data) || !isBinarySearchTreeWithoutList(root.right, root.data, max))
            return false;

        return true;

    }

    public static TreeNodee successor(TreeNodee root) {

        if (root == null)
            return root;

        if (root.right != null)
            return minimum(root);

        TreeNodee y = root.parent;
        while (y.parent != null && root == y.right) {
            root = y;
            y = y.parent;

        }

        return y;

    }

    private static TreeNodee minimum(TreeNodee root) {

        while (root.left != null)
            root = root.left;

        return root;
    }

    private static TreeNodee minimumRecursively(TreeNodee root) {

        TreeNodee minimum = null;

        if (root.left != null)
            minimum = minimumRecursively(root.left);

        return minimum;
    }

    public static void main(String[] args) {

        TreeNodee one = new TreeNodee(1);
        TreeNodee two = new TreeNodee(2);
        TreeNodee three = new TreeNodee(3);
        TreeNodee four = new TreeNodee(4);
        TreeNodee five = new TreeNodee(5);
        TreeNodee six = new TreeNodee(6);
        TreeNodee seven = new TreeNodee(7);


        four.left = two;
        four.right = six;

        two.left = one;
        two.right = three;

        six.left = five;
        six.right = seven;

        // ***********************************************************


        ArrayList<Integer> result = new ArrayList<>();
        System.out.println(Trees.isBinarySearchTreeWithoutList(four, Integer.MIN_VALUE, Integer.MAX_VALUE));

        /*for (Integer item : result)
            System.out.print(item + " ");
*/

    }

}
