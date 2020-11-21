public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] preorder, inorder;
        TreeNode root;
        preorder = new int[]{3, 9, 20, 15, 7};
        inorder = new int[]{9, 3, 15, 20, 7};
        root = solution.buildTree(preorder, inorder);
        TreeUtils.traverse(root);
    }
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, inorder, 0, inorder.length);
    }

    private TreeNode build(int[] preorder, int l1, int[] inorder, int l2, int r2) {
        if (preorder.length <= l1 || r2 <= l2) {
            return null;
        }
        int val = preorder[l1];
        TreeNode node = new TreeNode(val);
        for (int i = l2; i < r2; i++) {
            if (inorder[i] == val) {
                if (l2 != i && i != r2 - 1) {
                    node.left = build(preorder, l1 + 1, inorder, l2, i);
                    node.right = build(preorder, l1 + 1 + (i - l2), inorder, i + 1, r2);
                } else if (l2 != i) {
                    node.left = build(preorder, l1 + 1, inorder, l2, i);
                } else if (i != r2 - 1) {
                    node.right = build(preorder, l1 + 1, inorder, i + 1, r2);
                }
                break;
            }
        }
        return node;
    }
}