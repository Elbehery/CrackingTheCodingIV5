package cracks.Tree;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by mustafa on 20.03.16.
 */
public class FindPathInGraph {

    public boolean findPathBetweenTwoNodes(TreeNode start, TreeNode end) {

        if (start == end)
            return true;

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        HashSet<TreeNode> visited = new HashSet<TreeNode>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {

            TreeNode current = queue.removeFirst();
            for (TreeNode adj : current.getAdjacencyList()) {
                if (!visited.contains(adj)) {
                    if (adj == end) {
                        return true;
                    }

                    visited.add(adj);
                    queue.add(adj);

                }
            }
        }


        return false;

    }
}
