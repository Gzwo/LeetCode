public class Main {
    public static void main(String[] args) {
        TreeNode root = TreeUtils.build(TreeUtils.scan());
        Solution solution = new Solution();
        System.out.println(solution.longestUnivaluePath(root));
    }
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
    /* answer variable */
    private int ans;

    public int longestUnivaluePath(TreeNode root) {
        /* answer initialization */
        this.ans = 0;

        helper(root);

        return ans;
    }

    private int helper(TreeNode node) {
        /* recursion base case */
        if (node == null) return 0;

        /* left and right */
        int left = helper(node.left);
        int right = helper(node.right);

        /* left + current, right + current */
        int leftPlusCur = 0, rightPlusCur = 0;
        if (node.left != null && node.left.val == node.val) {
            leftPlusCur = left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            rightPlusCur = right + 1;
        }

        /* update answer variable */
        ans = Math.max(ans, leftPlusCur + rightPlusCur);

        /* return max(plusCur) */
        return Math.max(leftPlusCur, rightPlusCur);
    }
}