import cracks.Tree.TreeNode;

/**
 * Created by mustafa on 22.03.16.
 */
public class Algos {


    public static void heapSort(int[] arr) {

        int heapSize = arr.length;
        buildMaxHeap(arr);

        for (int i = arr.length - 1; i > 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;

            heapSize--;
            maxHeapify(arr, 0, heapSize);

        }


        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }


    public static void buildMaxHeap(int[] arr) {

        int length = arr.length;
        int heapSize = length;

        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }

        for (int i = (length / 2) - 1; i >= 0; i--)
            maxHeapify(arr, i, heapSize);


    }


    public static void maxHeapify(int[] arr, int index, int heapSize) {

        int leftChild = getLeftChild(index);
        int rightChild = getRightChild(index);

        int largest = 0;

        if (leftChild < heapSize && arr[leftChild] > arr[index])
            largest = leftChild;
        else
            largest = index;


        if (rightChild < heapSize && arr[rightChild] > arr[largest])
            largest = rightChild;

        if (largest != index) {

            int tmp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = tmp;
            maxHeapify(arr, largest, heapSize);
        }

    }

    public static int getLeftChild(int index) {

        return 2 * index + 1;
    }


    public static int getRightChild(int index) {

        return 2 * index + 2;
    }


    public static TreeNode search(TreeNode root, int k) {

        if (root == null || k == root.getData())
            return root;

        if (k < root.getData())
            return search(root.getLeft(), k);

        else
            return search(root.getRight(), k);
    }


    public static TreeNode searchIteratively(TreeNode root, int k) {

        while (root != null && root.getData() != k) {
            if (k < root.getData())
                root = root.getLeft();
            else
                root = root.getRight();
        }

        return root;
    }


    public static TreeNode minimum(TreeNode root) {

        if (root == null)
            return root;

        minimum(root.getLeft());

        return root;
    }


    public static TreeNode minimumIteratively(TreeNode root) {

        while (root.getLeft() != null)
            root = root.getLeft();


        return root;
    }

    public static int binarySearchIteratively(int[] arr, int x) {

        int low = 0;
        int high = arr.length - 1;

        while (low < high) {

            int mid = (high - low) / 2;

            if (arr[mid] < x)
                low = mid + 1;
            else if (arr[mid] > x)
                high = mid - 1;
            else
                return mid;
        }

        return -1;


    }

    public static int binarySearchRecursively(int[] arr, int low, int high, int x) {

        if (low > high)
            return -1;

        int mid = (low + high) / 2;

        if (arr[mid] < x)
            binarySearchRecursively(arr, mid + 1, high, x);
        else if (arr[mid] > x)
            binarySearchRecursively(arr, low, mid - 1, x);

        return mid;
    }


    public static TreeNode maximum(TreeNode root) {

        while (root.getRight() != null)
            root = root.getRight();


        return root;
    }

    public static TreeNode successor(TreeNode root) {

        if (root.getRight() != null)
            return minimum(root.getRight());


        TreeNode y = root.getParent();
        while (y != null && root == y.getRight()) {

            root = y;
            y = y.getParent();

        }
        return y;
    }


    public static void main(String[] args) {

        int[] tst = {2, 5, 6, 1, 9, 10, 12, 1};

        Algos.heapSort(tst);

    }
}
