public class Main {
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {

        int nodeCount = 0;
        TreeNode left = root;
        TreeNode right = root;
        while (left != null && right != null) {

            int lH = 1, rH = 1;
            TreeNode l = left, r = right;
            while (l != null) {
                break;
            }
            break;
        }

        return 0;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}