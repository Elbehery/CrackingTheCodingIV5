package cracks.Stack;

import cracks.Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by mustafa on 20.03.16.
 */
public class CreateLinkedListOfEachLevelInTree {

    public void createListByLevel(TreeNode root, ArrayList<LinkedList<TreeNode>> result, int level) {

        if (root == null)
            return;

        if (result.size() - 1 < level) {
            result.add(new LinkedList<TreeNode>());
        }

        LinkedList<TreeNode> currentLevelList = result.get(level - 1);
        currentLevelList.add(root);
        createListByLevel(root.getLeft(), result, level + 1);
        createListByLevel(root.getRight(), result, level + 1);

    }

    public ArrayList<LinkedList<TreeNode>> createListByLevel(TreeNode root) {

        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
        createListByLevel(root, result, 0);
        return result;
    }
}
