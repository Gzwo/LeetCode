import java.util.LinkedList;
import java.util.List;

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

    private List<String> paths;

    public List<String> binaryTreePaths(TreeNode root) {
        paths = new LinkedList<>();
        /* 处理特殊情形 */
        if (root == null) {
            return paths;
        }

        traverse(root, new StringBuilder());
        return paths;
    }

    private void traverse(TreeNode node, StringBuilder builder) {
        /* 仅在 root 之后加箭头 */
        if (builder.length() != 0) {
            builder.append("->");
        }
        builder.append(node.val);
        /* 如果当前节点是叶子节点，返回路径 */
        if (node.left == null && node.right == null) {
            paths.add(builder.toString());
        }
        /* 否则继续遍历 */
        else {
            if (node.left != null) {
                traverse(node.left, new StringBuilder(builder));
            }
            if (node.right != null) {
                traverse(node.right, new StringBuilder(builder));
            }
        }
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