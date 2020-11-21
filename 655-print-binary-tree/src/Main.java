import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        List<List<String>> A4 = solution.printTree(n1);
        for (int i = 0; i < A4.size(); i++) {
            List<String> layer = A4.get(i);
            for (int j = 0; j < layer.size(); j++) {
                System.out.print(layer.get(j));
            }
            System.out.println();
        }
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
    private int treeDepth;
    private List<List<String>> A4;

    public List<List<String>> printTree(TreeNode root) {
        this.treeDepth = 0;
        determineDepth(root, 1);

        A4 = new ArrayList<>(treeDepth);
        if (treeDepth == 0) return A4;

        /* 宽度 */
        int width = (int) Math.pow(2, treeDepth) - 1;
        /* 对打印内容进行初始化 */
        String[] layer0 = new String[width];
        Arrays.fill(layer0, "");
        List<String> layer = new ArrayList<>(Arrays.asList(layer0));
        for (int i = 0; i < treeDepth; i++) {
            A4.add(new ArrayList<>(layer));
        }

        fillA4(root, 0, 0, width);

        return A4;
    }

    /* 节点 start end */
    private void fillA4(TreeNode node, int depth, int start, int end) {
        if (node == null) return;
        int mid = (start + end) / 2;
        List<String> layer = A4.get(depth);
        layer.set(mid, String.valueOf(node.val));
        fillA4(node.left, depth + 1, start, mid);
        fillA4(node.right, depth + 1, mid + 1, end);
    }

    /* 遍历二叉树以确定其深度，非空的根节点深度为 1 */
    private void determineDepth(TreeNode cur, int curDepth) {
        if (cur == null) return;
        else treeDepth = Math.max(treeDepth, curDepth );
        determineDepth(cur.left, curDepth + 1);
        determineDepth(cur.right, curDepth + 1);
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