import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {

        List<Integer> LV = new LinkedList<>();

        if (root == null) {
            return LV;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Integer maxOfLevel = Integer.MIN_VALUE;
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = q.poll();
                maxOfLevel = Math.max(maxOfLevel, cur.val);
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            LV.add(maxOfLevel);
        }

        return LV;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}