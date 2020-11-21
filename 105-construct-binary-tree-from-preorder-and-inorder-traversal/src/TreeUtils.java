import java.util.Scanner;

public class TreeUtils {
    public static TreeNode build(Integer[] nodes) {
        TreeNode[] treeNodes = new TreeNode[nodes.length];

        /* 创建树节点 */
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == null) {
                treeNodes[i] = null;
            } else {
                treeNodes[i] = new TreeNode(nodes[i]);
            }
        }

        /* 树节点连接 */
        for (int i = 0; i < treeNodes.length; i++) {
            /* 跳过空节点 */
            if (treeNodes[i] == null) continue;
            /* 构建左子树关系 */
            if (2 * i + 1 < treeNodes.length) {
                treeNodes[i].left = treeNodes[2 * i + 1];
            }
            /* 构建右子树关系 */
            if (2 * i + 2 < treeNodes.length) {
                treeNodes[i].right = treeNodes[2 * i + 2];
            }
        }

        return treeNodes.length == 0 ? null : treeNodes[0];
    }

    public static Integer[] scan() {
        /* 返回值 */
        Integer[] nodes = null;
        Scanner scanner = new Scanner(System.in);
        String s;
        if (scanner.hasNextLine()) {
            s = scanner.nextLine();
            // [1, 2, 3, null, null, 4, 5]
            int leftSquareBracket = s.indexOf("[");
            int rightSquareBracket = s.indexOf("]");
            s = s.substring(leftSquareBracket + 1, rightSquareBracket);
            String[] split = s.split(",");
            int size = split.length;
            nodes = new Integer[size];
            for (int i = 0; i < split.length; i++) {
                String trim = split[i].trim();
                if (trim.equals("null")) {
                    nodes[i] = null;
                } else {
                    nodes[i] = Integer.parseInt(trim);
                }
            }
        }
        return nodes;
    }

    /* 前序 */
    public static void traverse(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }
        System.out.println(root.val);
        traverse(root.left);
        traverse(root.right);
    }
}
